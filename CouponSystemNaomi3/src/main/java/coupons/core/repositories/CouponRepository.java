package coupons.core.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import coupons.core.entities.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {

	boolean existsByTitleAndCompanyId(String title, int companyId);
	boolean existsByIdAndCompanyId(int couponId, int companyId);
	Optional<Coupon> findCouponByIdAndCompanyId(int couponId, int companyId);
	
	List<Coupon> findCouponsByCompanyId(int companyId);
	List<Coupon> findCouponsByCustomersId(int customerId);
	
	long deleteByEndDateBefore(LocalDate date);
}
