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
public class Application2 {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(Application2.class, args);

		UniversityRepo universityRepo = ctx.getBean(UniversityRepo.class);
		StudentRepo studentRepo = ctx.getBean(StudentRepo.class);
		MyService service = ctx.getBean(MyService.class);
		
		Optional<University> opt = universityRepo.findById(1);
		if(opt.isPresent()) {
			University univIvrit = opt.get();
			Student st1 = new Student(0, "Dani", univIvrit);
			Student st2 = new Student(0, "Maya", univIvrit);
			Student st3 = new Student(0, "Yossi", univIvrit);
			Student[] students = {st1, st2, st3};
			for (Student student : students) {
				service.addStudent(student);
			}
		}else {
			System.out.println("University NOT FOUND");
		}
	}
}
