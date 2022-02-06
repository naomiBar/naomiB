package app.core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.core.entities.Item;
import app.core.entities.Store;
import app.core.exceptions.StoreExceptions;
import app.core.repos.ItemRepo;
import app.core.repos.StoreRepo;

@Service
@Transactional
public class StoreService {
	
	@Autowired
	private ItemRepo itemRepo;
	@Autowired
	private StoreRepo storeRepo;
	
	public int addStrore(Store store) throws StoreExceptions {
		if(this.storeRepo.existsById(store.getId())) {
			throw new StoreExceptions("addStrore failed - store id " + store.getId() + " already exists");			
		}
		return this.storeRepo.save(store).getId();
	}
	
	public Store getOneStore(int storeId) throws StoreExceptions {
		Optional<Store> opt = this.storeRepo.findById(storeId);
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new StoreExceptions("getOneStore failed - store id " + storeId + " NOT found");
	}
	
	public List<Store> getAllStores(){
		return this.storeRepo.findAll();
	}
	
	public void updateStore(Store store) throws StoreExceptions {
		if(this.storeRepo.existsById(store.getId())) {
			this.storeRepo.save(store); //update
		}else {
			throw new StoreExceptions("updateStore failed - store id " + store.getId() + " NOT found");
		}
	}
	
	public void deleteStore(int storeId) throws StoreExceptions {
		if(this.storeRepo.existsById(storeId)) {
			this.storeRepo.deleteById(storeId);
		}else {
			throw new StoreExceptions("deleteStore failed - store id " + storeId + " NOT found");			
		}
	}
	
	public void addItemToStore(Item item, int storeId) throws StoreExceptions {
		Store store = getOneStore(storeId);
		store.addItem(item);
	}
	
	public Item getOneItem(int itemId) throws StoreExceptions {
		Optional<Item> opt = this.itemRepo.findById(itemId);
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new StoreExceptions("getOneItem failed - item id " + itemId + " NOT found");
	}
	
	public List<Item> getItemsFromStore(int storeId) throws StoreExceptions{
		return getOneStore(storeId).getItems();
	}
	
	public void updateItem(Item item) throws StoreExceptions {
		if(this.itemRepo.existsById(item.getId())) {
			this.itemRepo.save(item);
		}else {
			throw new StoreExceptions("updateItem failed - item id " + item.getId() + " NOT found");
		}
	}
	
	public void deleteItem(int itemId) throws StoreExceptions {
		if(this.itemRepo.existsById(itemId)) {
			this.itemRepo.deleteById(itemId);
		}else {
			throw new StoreExceptions("deleteItem failed - item id " + itemId + " NOT found");
		}
	}
	
}
