package app.core;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import app.core.entities.Person;
import app.core.entities.Student;
import app.core.entities.Student.Gender;
import app.core.service.PersonService;
import app.core.service.StudentService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		
		PersonService personService = ctx.getBean(PersonService.class);
//		person(personService);
		
		StudentService studentService = ctx.getBean(StudentService.class);
		//insertStudent(studentService);
		//insertStudents(studentService);
		listOfAllStudentsSorted(studentService);
		listOfStudentsByGender(studentService);
		listOfMaleStudentsSorted(studentService);
		listOfStudentsOlderThan(studentService);
		listOfStudentsByName(studentService);
		listOfStudentsByActive(studentService);
		
	}

	private static void person(PersonService service) {
		service.addPerson(new Person(0, "naomi", 21));
		service.addPerson(new Person(0, "odel", 17));
		
		System.out.println(">>>>> " + service.findPerson(1));
		System.out.println(">>>>> " + service.findPerson(2));
		
		service.updatePerson(new Person(1, "Naomi Bar", 21));
		
		service.deletePerson(2);
	}

	private static void insertStudent(StudentService service) {
		service.addStudent(new Student(0, "naomi", 21, "naomi@mail", Gender.F, LocalDate.of(2020, 1, 1), true));
		service.addStudent(new Student(0, "odel", 17, "odel@mail", Gender.T, LocalDate.of(2020, 1, 1), false));
	}
	
	private static void insertStudents(StudentService service) {
		for(int i=0; i<10; i++) {
			String name = "student" + (i+1);
			Student student = new Student(0, name, 0, name + "@mail", null, LocalDate.of(2020, 1, 1), true);
			student.setAge((int) ((Math.random()*21) + 20)); //20-40
			student.setGender(Math.random() > 0.5 ? Gender.F : Gender.M);
			student.setActive(Math.random() > 0.5 ? true : false);
			service.addStudent(student);
		}
	}
	
	private static void listOfAllStudentsSorted(StudentService service) {	
		System.out.println("\n\t allStudentsSorted:");
//		List<Student> allStudents = service.getAllStudents(Sort.by("age")); //asc-default
//		List<Student> allStudents = service.getAllStudents(Sort.by(Direction.ASC, "age"));  //young to old
		List<Student> allStudents = service.getAllStudents(Sort.by(Direction.DESC, "age")); //old to young
		for (Student student : allStudents) {
			System.out.println(">>>>>> " + student);
		}
	}
	
	private static void listOfStudentsByGender(StudentService service) {
		System.out.println("\n\t femaleStudents:");
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
	
	private static void listOfMaleStudentsSorted(StudentService service) {
		System.out.println("\n\t maleStudentsSorted:");
		List<Student> maleStudents = service.getMaleStudents(Sort.by("age"));
		for (Student student : maleStudents) {
			System.out.println(">>>>>> " + student);
		}
	}
	
	private static void listOfStudentsOlderThan(StudentService service) {
		int age = 30;
		System.out.println("\n\t studentsOlderThan-" + age + ":");
		List<Student> studentsOlderThan = service.getStudentsOlderThan(age);
		for (Student student : studentsOlderThan) {
			System.out.println(">>>>>> " + student);
		}
	}
	
	private static void listOfStudentsByName(StudentService service) {
		String name = "Naomi";
		System.out.println("\n\t studentsByName-" + name + ":");
		List<Student> studentsByName = service.getStudentsByName(name);
		for (Student student : studentsByName) {
			System.out.println(">>>>>> " + student);
		}
	}
	
	private static void listOfStudentsByActive(StudentService service) {
		System.out.println("\n\t studentsByActive - True:");
		List<Student> studentsByActive = service.getStudentsByActiveIsTrue();
		for (Student student : studentsByActive) {
			System.out.println(">>>>>> " + student);
		}
		System.out.println("\n\t studentsByActive - False:");
		studentsByActive = service.getStudentsByActiveFalse();
		for (Student student : studentsByActive) {
			System.out.println(">>>>>> " + student);
		}
	}
}
