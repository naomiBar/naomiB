package trainer.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Gym {

	private RunningTrainer runningTrainer;
	private TenisTrainer tenisTrainer;
	private SwimmingTrainer swimmingTrainer;

	public Gym() {
	}

	@Autowired
	public Gym(RunningTrainer runningTrainer, TenisTrainer tenisTrainer, SwimmingTrainer swimmingTrainer) {
		super();
		this.runningTrainer = runningTrainer;
		this.tenisTrainer = tenisTrainer;
		this.swimmingTrainer = swimmingTrainer;
	}

	public RunningTrainer getRunningTrainer() {
		return runningTrainer;
	}

	public TenisTrainer getTenisTrainer() {
		return tenisTrainer;
	}

	public SwimmingTrainer getSwimmingTrainer() {
		return swimmingTrainer;
	}

	@Override
	public String toString() {
		return "Gym [runningTrainer = " + runningTrainer.getTrainProgram() + ",\n    tenisTrainer = "
				+ tenisTrainer.getTrainProgram() + ",\n    swimmingTrainer = " + swimmingTrainer.getTrainProgram()
				+ "]";
	}

}
