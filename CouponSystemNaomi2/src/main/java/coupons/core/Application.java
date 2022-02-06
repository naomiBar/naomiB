package coupons.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		CouponExpirationDailyJob dailyJob = null;
		try {
			ApplicationContext ctx = SpringApplication.run(Application.class, args);
			dailyJob = ctx.getBean(CouponExpirationDailyJob.class);
			dailyJob.startDailyJob();

		} catch (Exception e) {
			System.err.println("EROR: " + e.getMessage());
			System.err.println("CAUSE: " + e.getCause());
		} finally {
			try {
				System.out.println("\n>>> coupon system shutdown in 5 seconds");
				Thread.sleep(5000);
				if (dailyJob != null) {
					dailyJob.stopDailyJob();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
