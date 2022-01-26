package app.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Student;
import app.core.entities.University;
import app.core.repos.StudentRepo;
import app.core.repos.UniversityRepo;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(Application.class, args);

		UniversityRepo universityRepo = ctx.getBean(UniversityRepo.class);
		StudentRepo studentRepo = ctx.getBean(StudentRepo.class);
		
		University univIvrit = new University(0, "Ivrit", "Israel");
		University univYale = new University(0, "Yale", "USA");
		
		Student student = new Student(0, "Dani", univIvrit);
		studentRepo.save(student);
		
		student = new Student(0, "John", univYale);
		studentRepo.save(student);
	}
}
