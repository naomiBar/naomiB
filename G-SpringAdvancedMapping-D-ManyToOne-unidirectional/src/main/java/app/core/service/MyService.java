package app.core.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.core.entities.Student;
import app.core.entities.University;
import app.core.repos.StudentRepo;
import app.core.repos.UniversityRepo;

@Service
@Transactional
public class MyService {

	@Autowired
	private StudentRepo studentRepo;
	@Autowired
	private UniversityRepo universityRepo;

	public void addStudent(Student student) {
		University university = this.universityRepo.save(student.getUniversity());
		student.setUniversity(university);
		this.studentRepo.save(student);
	}
	
	public University getUniversity(int id) {
		Optional<University> opt = this.universityRepo.findById(id);
		if(opt.isPresent()) {
			University university = opt.get();
			return university;
		}
		return null;
	}
}
