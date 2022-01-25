package app.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.dao.PersonDao;
import app.core.entities.Person;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		
		PersonDao personDao = ctx.getBean(PersonDao.class);
		
		//addPerson
		personDao.addPerson(new Person(111, "naomi", 21));
		
		//findPerson
		Person person = personDao.findPerson(111);
		System.out.println(">>>>>> " + person);
		
		//updatePerson
		personDao.updatePerson(new Person(111, "Naomi Bar", 21));
		
		//deletePerson
		personDao.deletePerson(111);
		
	}

}
