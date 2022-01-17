package car.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import car.core.beans.Car;

@Configuration
@ComponentScan //scans classes in base package
public class Config {
	
	private static int c = 101;
	
	@Bean //a bean method is another bean definition (the first one was @Componet)
	@Scope("prototype")
	public Car numberedCar() {
		Car car = new Car();
		car.setNumber(c++);
		return car;
	}

}