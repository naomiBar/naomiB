package vehicle.core.engine;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class BoatEngine implements Engine{

	@Override
	public void switchOn() {
		System.out.println("boat engine ON");
	}
	
	@Override
	public void switchOff() {
		System.out.println("boat engine OFF");
	}
}
