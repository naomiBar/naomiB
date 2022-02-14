package app.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.core.entities.Item;
import app.core.entities.Store;
import app.core.exceptions.StoreExceptions;
import app.core.service.StoreService;

@RestController
@RequestMapping("/api/store") //http://localhost:8080/api/store
public class StoreController {

	@Autowired
	private StoreService storeService;
	
	@PostMapping
	public ResponseEntity<?> addStore(@RequestBody Store store) {
		try {
			return ResponseEntity.ok("store added: " + this.storeService.addStrore(store));
		} catch (StoreExceptions e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@GetMapping("/getOneStore/{storeId}")
	public ResponseEntity<?> getOneStore(@PathVariable int storeId) {
		try {
			Store store = this.storeService.getOneStore(storeId);
			return ResponseEntity.ok(store);
		}catch (StoreExceptions e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	
	@GetMapping("/getAllStores")
	public List<Store> getAllStores(){
		return this.storeService.getAllStores();
	}
	
	@PutMapping("/updateStore")
	public ResponseEntity<?> updateStore(@RequestBody Store store){
		try {
			this.storeService.updateStore(store);
			return ResponseEntity.ok("store updated");
		}catch (StoreExceptions e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@DeleteMapping("/deleteStore/{storeId}")
	public ResponseEntity<?> deleteStore(@PathVariable int storeId){
		try {
			this.storeService.deleteStore(storeId);
			return ResponseEntity.ok("store id " + storeId + " deleted");
		} catch (StoreExceptions e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@PostMapping("/addItemToStore/{storeId}")
	public ResponseEntity<?> addItemToStore(@PathVariable int storeId, @RequestBody Item item){
		try {
			this.storeService.addItemToStore(item, storeId);
			return ResponseEntity.ok("item added to store id " + storeId);
		} catch (StoreExceptions e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@GetMapping("/getOneItem/{itemId}")
	public ResponseEntity<?> getOneItem(@PathVariable int itemId){
		try {
			Item item = this.storeService.getOneItem(itemId);
			return ResponseEntity.ok(item);
		}catch (StoreExceptions e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getItemsFromStore/{storeId}")
	public ResponseEntity<?> getItemsFromStore(@PathVariable int storeId){
		try {
			return ResponseEntity.ok(this.storeService.getItemsFromStore(storeId));
		} catch (StoreExceptions e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@PutMapping("/updateItem")
	public ResponseEntity<?> updateItem(@RequestBody Item item){
		try {
			this.storeService.updateItem(item);
			return ResponseEntity.ok("item updated");
		}catch (StoreExceptions e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@DeleteMapping("/deleteItem/{itemId}")
	public ResponseEntity<?> deleteItem(@PathVariable int itemId){
		try {
			this.storeService.deleteItem(itemId);
			return ResponseEntity.ok("item id " + itemId + " deleted");
		} catch (StoreExceptions e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
}
