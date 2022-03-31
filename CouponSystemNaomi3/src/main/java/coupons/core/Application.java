package coupons.core;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import coupons.core.filters.ClientFilter;
import coupons.core.jws.util.JwtUtil;
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
	
	
	@Bean
	//register and map the filter:
	public FilterRegistrationBean<ClientFilter> filter(JwtUtil jwtUtil){
		
		//container for registering filters:
		FilterRegistrationBean<ClientFilter> filterRegistrationBean = new FilterRegistrationBean<>();
		
		//register our filter - set the filter:
		ClientFilter clientFilter = new ClientFilter(jwtUtil);
		filterRegistrationBean.setFilter(clientFilter);
		
		//map the filter to a url pattern:
		filterRegistrationBean.addUrlPatterns("/api/*");
		
		//return the FilterRegistrationBean:
		return filterRegistrationBean;
	}
}
