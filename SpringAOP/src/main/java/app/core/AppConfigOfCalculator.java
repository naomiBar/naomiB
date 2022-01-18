package app.core;

import javax.swing.JOptionPane;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

import app.core.beans.CalculatorInterface;
import app.core.log.LoginManager;

@Configuration
@ComponentScan
@PropertySource("application.properties")
@EnableAspectJAutoProxy // without this annotation there is no proxy
public class AppConfigOfCalculator {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfigOfCalculator.class);
		
		LoginManager loginManager = ctx.getBean(LoginManager.class);
		boolean logged = loginManager.login("admin", "1234");
		System.out.println(logged);
		

		int a = Integer.parseInt(JOptionPane.showInputDialog("enter 1st number:"));
		int b = Integer.parseInt(JOptionPane.showInputDialog("enter 2sc number:"));
		
		CalculatorInterface calc = ctx.getBean(CalculatorInterface.class);
		try {
			String res = calc.div(a, b);
			System.out.println("MAIN: " + res);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		
		ctx.close();

	}

}
