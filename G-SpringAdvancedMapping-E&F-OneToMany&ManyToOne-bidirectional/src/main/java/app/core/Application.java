package app.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Student;
import app.core.entities.University;
import app.core.repos.UniversityRepo;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		
		Student st1 = new Student(0, "aaa", null);
		Student st2 = new Student(0, "bbb", null);
		Student st3 = new Student(0, "ccc", null);
		Student st4 = new Student(0, "ddd", null);
		
		University univYale = new University(0, "Yale", "USA", null);
		University univIvrit = new University(0, "Ivrit", "Israel", null);
		
		univYale.addStudent(st1);
		univYale.addStudent(st2);
		univIvrit.addStudent(st3);
		univIvrit.addStudent(st4);
		
		UniversityRepo universityRepo = ctx.getBean(UniversityRepo.class);
		universityRepo.save(univYale);
		universityRepo.save(univIvrit);
	}
}
