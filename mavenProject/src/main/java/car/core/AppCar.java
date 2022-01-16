package car.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import car.core.beans.Car;

public class AppCar {

	public static void main(String[] args) {
		//create spring container instance 
		try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class)){ //config.class is a reference to the named class - in this care Config
			Car car1 = context.getBean("theCar", Car.class);
			car1.setNumber(111);
			System.out.println(car1);		

			
			Car car2 = context.getBean("numberedCar", Car.class);
			System.out.println(car2);		
			
			Car car3 = context.getBean("numberedCar", Car.class);
			System.out.println(car3);		
		}	
		// context.close(); //context need to close, buy we put inside a try so we don't need
	}
}
