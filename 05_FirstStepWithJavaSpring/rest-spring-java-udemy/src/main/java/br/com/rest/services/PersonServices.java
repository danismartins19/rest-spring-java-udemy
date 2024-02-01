package br.com.rest.services;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rest.exceptions.ResourceNotFoundException;
import br.com.rest.models.Person;
import br.com.rest.repositories.PersonRepository;

@Service
public class PersonServices {

	@Autowired
	PersonRepository repository;
	
	
	
	
	public List<Person> findAll(){
		return repository.findAll();
	}
	
	public Person findById(Long Id) {
		return repository.findById(Id)
				.orElseThrow(()-> new ResourceNotFoundException("No records found for this ID!"));
	}
	
	
	public Person create(Person person) {
		Person newPerson = repository.save(person);
		
		return newPerson;
	}
	
	public Person update(Person person, Long Id) {
		Person entity = repository.findById(Id)
				.orElseThrow(()-> new ResourceNotFoundException("No records found for this ID!"));
		
		entity.setName(person.getName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		return repository.save(entity);
	}
	
	public void delete(Long Id) {
		
		Person entity = repository.findById(Id)
				.orElseThrow(()-> new ResourceNotFoundException("No records found for this ID!"));
		
		repository.delete(entity);
	}
	
}
