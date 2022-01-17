package trainer.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RunningTrainer implements Trainer{

	@Value("${train.program.run: }")
	private String trainProgram;
	
	@Override
	public String getTrainProgram() {
		return trainProgram;
	}

}
