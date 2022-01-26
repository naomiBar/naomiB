package app.core;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Student;
import app.core.entities.University;
import app.core.repos.StudentRepo;
import app.core.repos.UniversityRepo;
import app.core.service.MyService;

@SpringBootApplication
public class Application3 {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(Application3.class, args);

		UniversityRepo universityRepo = ctx.getBean(UniversityRepo.class);
		StudentRepo studentRepo = ctx.getBean(StudentRepo.class);

		Optional<Student> opt = studentRepo.findById(1);
		if (opt.isPresent()) {
			Student student = opt.get();
			System.out.println(student);
			University university = student.getUniversity();
			System.out.println(university);
		}else {
			System.out.println("NOT FOUND");
		}
	}
}
