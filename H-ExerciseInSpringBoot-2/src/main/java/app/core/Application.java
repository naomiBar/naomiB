package app.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Product;
import app.core.entities.Store;
import app.core.service.MallService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		
		MallService mallService = ctx.getBean(MallService.class);
		
		mallService.addStrore(new Store(0, "Castro", null));
		System.out.println(">>store: " + mallService.getOneStore(1));
		System.out.println(">>all stores: " + mallService.getAllStoresInMall());
		
		mallService.addProductToStore(new Product(0, "T-shirt", 56), 1);
		System.out.println(">>product: " + mallService.getOneProtuct(1));
		System.out.println(">>all products: " + mallService.getAllProductsInMall());
		
		double price = 60;
		System.out.println(">>all products up to a price of " + price + " (inclusive): " + mallService.getProductsByPriceLessThanEqual(price));
		
		String prefix = "t";
		System.out.println(">>all products by name that starting with " + prefix + ": " + mallService.getProductsByNameStartingWith(prefix));
	}
}
