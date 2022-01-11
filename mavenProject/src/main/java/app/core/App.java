package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.core.beans.Person;

public class App {

	public static void main(String[] args) {

		//create spring container
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		
		Person p1 = context.getBean(Person.class);
		p1.setName("Naomi");
		Person p2 = context.getBean(Person.class);
		p2.setName("Odel");
		Person p3 = context.getBean(Person.class);
		p3.setName("Talya");
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		
		context.close();
	}

}
