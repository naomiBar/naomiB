package vehicle.core.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import vehicle.core.engine.Engine;

@Component("theRaceCar") //Component means the instances of this class are managed by spring container
@Scope("prototype") //prototype means we have many instance
public class RaceCar implements Vehicle{

	static int c; //this is just for generating new car number
	private int number = ++c;

	@Autowired
//	@Qualifier("carEngine")
//	private Engine engine; //this is a dependency - helper class
	private Engine carEngine; //this is a dependency - helper class
	
	@Override
	public void start() {
		this.carEngine.switchOn();
		System.out.println("starts race car " + number);
	}

	@Override
	public void goTo(String destination) {
		System.out.println("car " + number + " going to " + destination);				
	}

	@Override
	public void stop() {
		this.carEngine.switchOff();
		System.out.println("stops race car " + number);		
	}

	
}
