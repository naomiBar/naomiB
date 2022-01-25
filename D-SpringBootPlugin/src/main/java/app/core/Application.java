package app.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import app.core.beans.Point;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		try(ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);){
			
			Point p1 = ctx.getBean(Point.class);
			p1.setX(10);
			p1.setY(20);
			System.out.println(p1);
			
			Point p2 = ctx.getBean(Point.class);
			p2.setX(5);
			p2.setY(25);
			System.out.println(p2);
			
			System.out.println(p1.equals(p2));
			
		}
		
	}

}
