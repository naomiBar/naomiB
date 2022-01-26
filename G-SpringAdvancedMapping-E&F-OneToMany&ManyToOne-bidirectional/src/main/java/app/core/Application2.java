package app.core;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.University;
import app.core.repos.StudentRepo;
import app.core.repos.UniversityRepo;

@SpringBootApplication
public class Application2 {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(Application2.class, args);

		UniversityRepo universityRepo = ctx.getBean(UniversityRepo.class);
		StudentRepo studentRepo = ctx.getBean(StudentRepo.class);

		int universityId = 1;
		Optional<University> opt = universityRepo.findById(universityId);
		if(opt.isPresent()) {
			University university = opt.get();
			System.out.println("university:" + university);
			//when fetch = FetchType.EAGER in University Class:
//			System.out.println("Students:" + university.getStudents());
			//when fetch = FetchType.Lazy in University Class:
			System.out.println("Students:" + studentRepo.findStudentsByUniversityId(universityId));
		}else {
			System.out.println("University NOT FOUND");
		}
	}
}
