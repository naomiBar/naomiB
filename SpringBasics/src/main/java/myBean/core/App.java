package myBean.core;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan
public class App{
	public static void main(String[] args) throws InterruptedException {
		System.out.println("App START");
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
		
		
		Thread.sleep(10000);
		ctx.close();
		System.out.println("App END");
	}
}
