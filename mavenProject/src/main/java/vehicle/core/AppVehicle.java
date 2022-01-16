package vehicle.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import vehicle.core.beans.FamilyCar;
import vehicle.core.beans.Vehicle;

public class AppVehicle {

	public static void main(String[] args) {
		//create spring container instance 
		try(AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class)){ //config.class is a reference to the named class - in this care Config
			Vehicle vehicle = ctx.getBean(Vehicle.class); //default familyCar
			vehicle.start();
			vehicle.goTo("Tel-Aviv");
			vehicle.stop();
			
			System.out.println("==================");
			
			Vehicle vehicle2 = ctx.getBean("theRaceCar", Vehicle.class);
			vehicle2.start();
			vehicle2.goTo("Jerusalem");
			vehicle2.stop();
			
			System.out.println("==================");
			
			
			Vehicle vehicle3 = ctx.getBean("theBoat", Vehicle.class);
			vehicle3.start();
			vehicle3.goTo("Greace");
			vehicle3.stop();
			
			System.out.println("==================");
			
			Vehicle vehicle4 = ctx.getBean("airplane", Vehicle.class);
			vehicle4.start();
			vehicle4.goTo("France");
			vehicle4.stop();

			System.out.println("==================");
			
			FamilyCar car = ctx.getBean(FamilyCar.class);
			System.out.println("maxSpeed: " + car.getMaxSpeed());
		}	
		// context.close(); //context need to close, buy we put inside a try so we don't need
	}
}
