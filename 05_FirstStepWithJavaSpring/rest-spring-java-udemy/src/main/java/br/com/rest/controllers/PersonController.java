package br.com.rest.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rest.dto.v1.PersonDTO;
import br.com.rest.services.PersonServices;
							
@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	public PersonServices personService;
	
	@GetMapping(value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonDTO findById(@PathVariable(value = "id") Long id) {
		return personService.findById(id);
	}
	
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PersonDTO> findAll() {
		
		return personService.findAll();
		
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonDTO create (@RequestBody PersonDTO person) {
		return personService.create(person);
	}
	
	@PutMapping("/{id}")
	public PersonDTO update (@RequestBody PersonDTO person, @PathVariable(value = "id") Long Id) {
		return personService.update(person, Id);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value= "id")Long Id ) {
		personService.delete(Id);
		return ResponseEntity.noContent().build();
	}
}
