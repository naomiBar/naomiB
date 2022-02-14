package coupons.core;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Application {

	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		
		
		System.out.println("\n>>> coupon system shutdown in 2 minutes");
		try {
			TimeUnit.MINUTES.sleep(2);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ctx.close();
	}
}
