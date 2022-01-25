package app.core.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.core.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

	//native sql - less recommended
	@Query(value = "select * from students where the_gender = 'F'", nativeQuery = true)
	List<Student> getFemaleStudents();
	
	//JPQL - a form of sql that is Entity oriented (not table oriented) 
	@Query(value = "from Student where gender = 'M'")
	List<Student> getMaleStudents();
	
	@Query(value = "from Student where gender = 'M'")
	List<Student> getMaleStudents(Sort sort);
	
	@Query(value = "from Student where age > :age")
	List<Student> getStudentsOlderThan(int age);
	
	//Derived Methods - get their meaning by method name:
	//introducer: key word to say what want - find, get, read, query
	//criteria: how to look for it - byName
	List<Student> findByName(String name);
	
	List<Student> findByActiveIsTrue();
	List<Student> findByActiveFalse();
	
	
	//more criteria:
	List<Student> findByNameStartingWith(String prefix);
	List<Student> findByNameEndingWith(String suffix);
	List<Student> findByNameContaining(String infix);
	List<Student> findByAgeLessThan(Integer age);
	List<Student> findByAgeLessThanEqual(Integer age);
	List<Student> findByAgeGreaterThan(Integer age);
	List<Student> findByAgeGreaterThanEqual(Integer age);
	List<Student> findByAgeBetween(Integer startAge, Integer endAge);
	//dates:
	List<Student> findByBirthDateAfter(LocalDate birthDate);
	List<Student> findByBirthDateBefore(LocalDate birthDate);
	//AND & OR
	List<Student> findByNameOrBirthDate(String name, LocalDate birthDate);
	List<Student> findByNameOrBirthDateAndActive(String name, LocalDate birthDate, Boolean active);
	//exists:
	boolean existsByName(String name);
	boolean existsByEmail(String email);
	boolean existsByEmailAndPassword(String email, String password);
}
