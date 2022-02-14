package coupons.core.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import coupons.core.entities.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

	boolean existsByNameOrEmail(String name, String email);
	boolean existsByIdAndName(int id, String email);
	Optional<Company> findCompanyByEmailAndPassword(String email, String password);
}
