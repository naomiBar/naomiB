package app.core;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Person;
import app.core.entities.Student;
import app.core.entities.Student.Gender;
import app.core.service.PersonService;
import app.core.service.StudentService;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringDataJpaApplication.class, args);
		
//		person(ctx);
		student(ctx);
		listOfStudent(ctx);
		listOfStudentByGender(ctx);
		
	}

	private static void person(ApplicationContext ctx) {
		
		PersonService service = ctx.getBean(PersonService.class);
		
		service.addPerson(new Person(0, "naomi", 21));
		service.addPerson(new Person(0, "odel", 17));
		
		System.out.println(">>>>> " + service.findPerson(1));
		System.out.println(">>>>> " + service.findPerson(2));
		
		service.updatePerson(new Person(1, "Naomi Bar", 21));
		
		service.deletePerson(2);
	}

	private static void student(ApplicationContext ctx) {

		StudentService service = ctx.getBean(StudentService.class);
		
		service.addStudent(new Student(0, "naomi", 21, "naomi@mail", Gender.F, LocalDate.of(2020, 1, 1), true));
		service.addStudent(new Student(0, "odel", 17, "odel@mail", Gender.T, LocalDate.of(2020, 1, 1), false));
	}
	
	private static void listOfStudent(ApplicationContext ctx) {
		StudentService service = ctx.getBean(StudentService.class);
		
		for(int i=0; i<10; i++) {
			String name = "student" + (i+1);
			Student student = new Student(0, name, 0, name + "@mail", null, LocalDate.of(2020, 1, 1), true);
			student.setAge((int) ((Math.random()*21) + 20)); //20-40
			student.setGender(Math.random() > 0.5 ? Gender.F : Gender.M);
			student.setActive(Math.random() > 0.5 ? true : false);
			service.addStudent(student);
		}
	}
	
	private static void listOfStudentByGender(ApplicationContext ctx) {
		
		StudentService service = ctx.getBean(StudentService.class);
		
		System.out.println("\t femaleStudents:");
		List<Student> femaleStudents = service.getFemaleStudents();
		for (Student student : femaleStudents) {
			System.out.println(">>>>>> " + student);
		}
		
		System.out.println("\n\t maleStudents:");
		List<Student> maleStudents = service.getMaleStudents();
		for (Student student : maleStudents) {
			System.out.println(">>>>>> " + student);
		}
	}
}
