package coupons.core;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableScheduling
@EnableSwagger2
public class Application {

	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		
		
		System.out.println("\n>>> coupon system shutdown in 2 minutes");
		try {
			TimeUnit.HOURS.sleep(4);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ctx.close();
	}
}
