package app.core.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	List<Product> findProductsByPriceLessThanEqual(Double price);
	List<Product> findProductsByNameStartingWith(String prefix);
	
}