package person.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import person.core.beans.Person;

@Configuration
@ComponentScan //scans classes in base package
public class AppPerson {
	
	public static void main(String[] args) {
		//create spring container instance
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppPerson.class); //config.class is a reference to the named class - in this care Config
		
		Person p1 = context.getBean(Person.class);
		p1.setName("Odel");
		Person p2 = context.getBean(Person.class);
		p2.setName("Talya");
		
		System.out.println(p1);
		System.out.println(p2);
		
		///////////////////////////////////////////////////////////////////////////////////
		
//		Person person = context.getBean("person", Person.class);
		Person person = context.getBean(Person.class); //put to the class person - @Primary
		System.out.println(person);
		
		Person person2 = context.getBean("getPerson",Person.class);
		System.out.println(person2);
		
		context.close(); //context need to close,
	}
	
	
	@Bean
	public String name() {
		return "Naomi";
	}
	
	@Bean
	public Person getPerson() {
		return new Person(101, "Naomi Bar", 21);
	}

}