package app.core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.core.entities.Student;
import app.core.repository.StudentRepository;
@Service
@Transactional
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	//CREATE
	public int addStudent(Student student) {
		Optional<Student> opt = this.studentRepository.findById(student.getId());
		if (opt.isEmpty()) {
			student = this.studentRepository.save(student);
			return student.getId();
		} else {
			throw new RuntimeException("addStudent failed - person id " + student.getId() + " already exists");
		}
	}
	
	//READ
	public Student findStudent(int sudentId) {
		Optional<Student> opt = this.studentRepository.findById(sudentId);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new RuntimeException("findStudent failed - person id " + sudentId + " not found");
		}
	}
	
	//UPDATE
	public void updateStudent(Student student) {
		Optional<Student> opt = this.studentRepository.findById(student.getId());
		if (opt.isPresent()) {
			this.studentRepository.save(student); // because this entity exist in the database it is updated (not created)
		} else {
			throw new RuntimeException("updateStudent failed - person id " + student.getId() + " not found");
		}
	}
	
	//DELETE
	public void deleteStudent(int studentId) {
		Optional<Student> opt = this.studentRepository.findById(studentId);
		if (opt.isPresent()) {
			this.studentRepository.deleteById(studentId);
		} else {
			throw new RuntimeException("deleteStudent failed - person id " + studentId + " not found");
		}
	}
	
	public List<Student> getAllStudents(Sort sort){
		return this.studentRepository.findAll(sort);
	}
	
	public List<Student> getFemaleStudents(){
		return this.studentRepository.getFemaleStudents();
	}
	
	public List<Student> getMaleStudents(){
		return this.studentRepository.getMaleStudents();
	}
	
	public List<Student> getMaleStudents(Sort sort){
		return this.studentRepository.getMaleStudents(sort);
	}
	
	public List<Student> getStudentsOlderThan(int age){
		return this.studentRepository.getStudentsOlderThan(age);
	}
	
	public List<Student> getStudentsByName(String name){
		return this.studentRepository.findByName(name);
	}
	
	public List<Student> getStudentsByActiveIsTrue(){
		return this.studentRepository.findByActiveIsTrue();
	}
	
	public List<Student> getStudentsByActiveFalse(){
		return this.studentRepository.findByActiveFalse();
	}
}

