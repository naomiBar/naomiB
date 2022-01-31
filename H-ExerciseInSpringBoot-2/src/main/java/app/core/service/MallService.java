package app.core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.core.entities.Product;
import app.core.entities.Store;
import app.core.repositories.ProductRepository;
import app.core.repositories.StoreRepository;

@Service
@Transactional
public class MallService {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private StoreRepository storeRepository;
	
	public int addStrore(Store store) {
		store = this.storeRepository.save(store);
		return store.getId();
	}
	
	public Store getOneStore(int storeId) {
		Optional<Store> opt = this.storeRepository.findById(storeId);
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new RuntimeException("getOneStore failed - store id " + storeId + " NOT found");
	}
	
	public List<Store> getAllStoresInMall(){
		return this.storeRepository.findAll();
	}
	
	public void updateStore(Store store) {
		Optional<Store> opt = this.storeRepository.findById(store.getId());
		if(opt.isPresent()) {
			this.storeRepository.save(store);
		}else {
			throw new RuntimeException("updateStore failed - store id " + store.getId() + " NOT found");
		}
	}
	
	public void deleteStore(int storeId) {
		Optional<Store> opt = this.storeRepository.findById(storeId);
		if(opt.isPresent()) {
			this.storeRepository.deleteById(storeId);;
		}else {
			throw new RuntimeException("deleteStore failed - store id " + storeId + " NOT found");
		}
	}
	
	public void addProductToStore(Product product, int storeId) {
		Optional<Store> opt = this.storeRepository.findById(storeId);
		if(opt.isPresent()) {
			Store store = opt.get();
			store.addProduct(product);
		}else {
			throw new RuntimeException("addProductToStore failed - store id " + storeId + " NOT found");			
		}
	}
	
	public Product getOneProtuct(int productId) {
		Optional<Product> opt = this.productRepository.findById(productId);
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new RuntimeException("getOneProtuct failed - product id " + productId + " NOT found");
	}
	
	public List<Product> getAllProductsInMall(){
		return this.productRepository.findAll();
	}
	
	public List<Product> getProductsByPriceLessThanEqual(Double price){
		return this.productRepository.findProductsByPriceLessThanEqual(price);
	}
	
	public List<Product> getProductsByNameStartingWith(String prefix){
		return this.productRepository.findProductsByNameStartingWith(prefix);
	}
	
	
}
