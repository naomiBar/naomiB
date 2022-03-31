package app.core.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.core.beans.Product;

@RestController
@CrossOrigin
@RequestMapping("/api/product")
public class ProductController {

	@GetMapping
	public List<Product> getProducts(){
		List<Product> products = new ArrayList<>();
		products.add(new Product(1, "Bread", 5.8, 600));
		products.add(new Product(2, "Milk", 5.8, 600));
		products.add(new Product(3, "Chocolate", 5.8, 600));
		products.add(new Product(4, "Honey", 5.8, 600));
		try {
			TimeUnit.SECONDS.sleep(1);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		return products;
	}
}
