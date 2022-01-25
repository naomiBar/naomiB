package trainer.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SwimmingTrainer implements Trainer{

	@Value("${train.program.swim: }")
	private String trainProgram;
	
	@Override
	public String getTrainProgram() {
		return trainProgram;
	}

}
