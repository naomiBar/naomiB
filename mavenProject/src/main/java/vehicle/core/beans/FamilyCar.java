package vehicle.core.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import vehicle.core.engine.Engine;


@Component("theFamilyCar") //Component means the instances of this class are managed by spring container
@Scope("prototype") //prototype means we have many instance
@Primary //default
public class FamilyCar implements Vehicle{
	
	static int c; //this is just for generating new car number
	private int number = ++c;
	
	// inject value from properties file - always text or numbers - not objects
	@Value("${car.max.speed:0}")
	private int maxSpeed;
	
	@Autowired
	@Qualifier("carEngine")
	private Engine engine; //this is a dependency - helper class
	
	@Override
	public void start() {
		this.engine.switchOn();
		System.out.println("starts family car " + number);
	}

	@Override
	public void goTo(String destination) {
		System.out.println("car " + number + " going to " + destination);				
	}

	@Override
	public void stop() {
		this.engine.switchOff();
		System.out.println("stops family car " + number);		
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

}
