package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.PersonService;
import com.example.demo.model.Person;

@RestController
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@RequestMapping("/create")
	public String create(@RequestParam String name) {
		Person p = personService.create(name);
		return p.toString();
	}
	
	@RequestMapping("/get")
	public Person getPerson(@RequestParam String name) {
		
		return personService.getByName(name);
		
	}
	
	@RequestMapping("/getAll")
	public List<Person> getAll(){
		return personService.getAll();
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam String name) {
		
		 personService.delete(name);
		return "Deleted"+ name;
	}
	
	@RequestMapping("/deleteAll")
	public String deleteAll() {
		personService.deleteAll();
		return "Deleted All Record";
	}
	
}
