package br.com.rest.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.rest.models.Person;
import br.com.rest.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	public PersonServices personService;
	
	
	
	@GetMapping
	public List<Person> findAll() {
		
		return personService.findAll();
		
	}
	
	@PostMapping
	public Person create (@RequestBody Person person) {
		return personService.create(person);
	}
	
	@PutMapping("/{id}")
	public Person update (@RequestBody Person person, @PathVariable(value = "id") Long Id) {
		return personService.update(person, Id);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value= "id")Long Id ) {
		personService.delete(Id);
		return ResponseEntity.noContent().build();
	}
}
