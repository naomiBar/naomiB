package vehicle.core.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import vehicle.core.engine.Engine;

@Component
@Scope("prototype") //prototype means we have many instance
public class Airplane implements Vehicle{

	static int c; //this is just for generating new car number
	private int number = ++c;
	
	@Autowired
	@Qualifier("airplaneEngine")
	private Engine engine; //this is a dependency - helper class
	
	@Override
	public void start() {
		this.engine.switchOn();
		System.out.println("starts airplane " + number);
	}

	@Override
	public void goTo(String destination) {
		System.out.println("airplane " + number + " flying to " + destination);				
	}

	@Override
	public void stop() {
		this.engine.switchOff();
		System.out.println("stops airplane " + number);		
	}

}