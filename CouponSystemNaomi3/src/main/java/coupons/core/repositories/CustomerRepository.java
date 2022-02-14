package coupons.core.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import coupons.core.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	boolean existsByEmail(String email);
	Optional<Customer> findCustomerByEmailAndPassword(String email, String password);
	
}
