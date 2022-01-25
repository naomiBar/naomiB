package trainer.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TenisTrainer implements Trainer{

	@Value("${train.program.tenis: }")
	private String trainProgram;
	
	@Override
	public String getTrainProgram() {
		return trainProgram;
	}

}
