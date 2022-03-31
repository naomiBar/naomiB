package app.core.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.entities.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

	public boolean existsByName(String name);
}
