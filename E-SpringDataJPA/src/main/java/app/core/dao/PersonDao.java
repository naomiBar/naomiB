package app.core.dao;


import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import app.core.entities.Person;

@Component
@Transactional //start an EntityManager session on each method call and close it at the end
public class PersonDao {
	
	@Autowired
	private EntityManager em; //a container for persisting entities
	
	//CREATE
	public void addPerson(Person person) {
		em.persist(person);
	}
	
	//READ
	public Person findPerson(int personId) {
		return em.find(Person.class, personId);
	}

	//UPDATE
	public void updatePerson(Person person) {
		Person personFromDB = findPerson(person.getId());
		personFromDB.setName(person.getName());
		personFromDB.setAge(person.getAge());
	}
	
	//DELETE
	public void deletePerson(int personId) {
		Person person = findPerson(personId);
		em.remove(person);		
	}
}
