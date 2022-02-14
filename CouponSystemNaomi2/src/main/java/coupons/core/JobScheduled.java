package coupons.core;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import coupons.core.repositories.CouponRepository;

@Component
@Transactional
public class JobScheduled {

	@Autowired
	private CouponRepository couponRepository;

	@Scheduled(cron = "0 0 0 * * *")
	public void job() {
		System.out.println("#### startDailyJob ####");
		long amount = couponRepository.deleteByEndDateBefore(LocalDate.now());
		if(amount == 1) {
			System.out.println("#### " + amount + " coupon was deleted ####");			
		}
		if(amount > 1) {
			System.out.println("#### " + amount + " coupons were deleted ####");			
		}
	}

}
