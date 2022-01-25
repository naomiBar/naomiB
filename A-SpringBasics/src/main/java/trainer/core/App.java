package trainer.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@ComponentScan
@PropertySource("application.properties")
public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
		
		Trainer[] trainers = new Trainer[3];
		trainers[0] = ctx.getBean("runningTrainer", Trainer.class);
		trainers[1] = ctx.getBean("tenisTrainer", Trainer.class);
		trainers[2] = ctx.getBean("swimmingTrainer", Trainer.class);
		
		for (Trainer trainer : trainers) {
			System.out.println(trainer.getClass().getSimpleName() + ": " + trainer.getTrainProgram());
		}
		
		System.out.println("=============================");
		
		Gym gym = ctx.getBean(Gym.class);
		System.out.println(gym);
		ctx.close();
	}

}
