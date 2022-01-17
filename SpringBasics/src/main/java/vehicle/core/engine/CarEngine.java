package vehicle.core.engine;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class CarEngine implements Engine{

	@Override
	public void switchOn() {
		System.out.println("car engine ON");
	}
	
	@Override
	public void switchOff() {
		System.out.println("car engine OFF");
	}
}