package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	public Person create(String name) {
		
		return personRepository.save(new Person(name));
		
	}
	
	public List<Person> getAll(){
		return personRepository.findAll();
	}
	
	public Person getByName(String name) {
		return personRepository.findByName(name);
	}
	
	public void deleteAll() {
		personRepository.deleteAll();
	}
	
	public void delete(String name) {
		Person p = personRepository.findByName(name);
		personRepository.delete(p);
	}

}
