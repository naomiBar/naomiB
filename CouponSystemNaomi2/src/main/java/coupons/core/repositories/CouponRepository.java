package coupons.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import coupons.core.entities.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {

	boolean existsByTitleAndCompanyId(String title, int companyId);
}
