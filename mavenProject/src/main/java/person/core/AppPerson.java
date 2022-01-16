package person.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import person.core.beans.Person;


public class AppPerson {

	public static void main(String[] args) {
		//create spring container instance
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class); //config.class is a reference to the named class - in this care Config
		
		Person p1 = context.getBean(Person.class);
		p1.setName("Naomi");
		Person p2 = context.getBean(Person.class);
		p2.setName("Odel");
		Person p3 = context.getBean(Person.class);
		p3.setName("Talya");
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		
		context.close(); //context need to close,
	}

}
