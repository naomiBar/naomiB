package app.core.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.core.entities.Person;
import app.core.repository.PersonRepository;

@Service
@Transactional
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	//CREATE
	public int addPerson(Person person) {
		Optional<Person> opt = this.personRepository.findById(person.getId());
		if (opt.isEmpty()) {
			person = this.personRepository.save(person);
			return person.getId();
		} else {
			throw new RuntimeException("addPerson failed - person id " + person.getId() + " already exists");
		}
	}

	//READ
	public Person findPerson(int personId) {
		Optional<Person> opt = this.personRepository.findById(personId);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new RuntimeException("findPerson failed - person id " + personId + " not found");
		}
	}

	//UPDATE
	public void updatePerson(Person person) {
		Optional<Person> opt = this.personRepository.findById(person.getId());
		if (opt.isPresent()) {
			this.personRepository.save(person); // because this entity exist in the database it is updated (not created)
		} else {
			throw new RuntimeException("updatePerson failed - person id " + person.getId() + " not found");
		}
	}

	//DELETE
	public void deletePerson(int personId) {
		Optional<Person> opt = this.personRepository.findById(personId);
		if (opt.isPresent()) {
			this.personRepository.deleteById(personId);
		} else {
			throw new RuntimeException("deletePerson failed - person id " + personId + " not found");
		}
	}

}
