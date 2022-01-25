package vehicle.core.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import vehicle.core.engine.Engine;

@Component("theBoat")
@Scope("prototype") //prototype means we have many instance
public class Boat implements Vehicle{

	static int c; //this is just for generating new car number
	private int number = ++c;
	
	@Autowired
	@Qualifier("boatEngine")
	private Engine engine; //this is a dependency - helper class
	
	@Override
	public void start() {
		this.engine.switchOn();
		System.out.println("starts boat " + number);
	}

	@Override
	public void goTo(String destination) {
		System.out.println("boat " + number + " going to " + destination);				
	}

	@Override
	public void stop() {
		this.engine.switchOff();
		System.out.println("stops boat " + number);		
	}

}