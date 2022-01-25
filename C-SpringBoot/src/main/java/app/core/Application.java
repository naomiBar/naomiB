package app.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import app.core.beans.Person;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		
		Person p1 = ctx.getBean("person", Person.class);
		p1.setId(101);
		p1.setName("Naomi");
		System.out.println(p1);
		
		Person p2 = ctx.getBean("thePerson", Person.class);
		System.out.println(p2);
		
		
	}
	
	@Bean
	public Person thePerson(@Value("${person.name:X}") String name) {
		Person p = new Person();
		p.setId(201);
		p.setName(name);
		return p;
	}

}
