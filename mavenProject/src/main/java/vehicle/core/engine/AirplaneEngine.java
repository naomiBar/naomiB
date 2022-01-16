package vehicle.core.engine;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class AirplaneEngine implements Engine{

	@Override
	public void switchOn() {
		System.out.println("airplane engine ON");
	}
	
	@Override
	public void switchOff() {
		System.out.println("airplane engine OFF");
	}
}
