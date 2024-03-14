package br.com.rest.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rest.dto.v1.PersonDTO;
import br.com.rest.exceptions.ResourceNotFoundException;
import br.com.rest.mapper.DozerMapper;
import br.com.rest.models.Person;
import br.com.rest.repositories.PersonRepository;

@Service
public class PersonServices {

	@Autowired
	PersonRepository repository;
	
	
	
	
	public List<PersonDTO> findAll(){
		
		return DozerMapper.parseListObjects(repository.findAll(), PersonDTO.class) ;
	}
	
	public PersonDTO findById(Long Id) {
		Person entity = repository.findById(Id)
				.orElseThrow(()-> new ResourceNotFoundException("No records found for this ID!"));
		
		return DozerMapper.parseObject(entity, PersonDTO.class);
	}
	
	
	public PersonDTO create(PersonDTO person) {
		
		var entity = DozerMapper.parseObject(person, Person.class);
		var dto =  DozerMapper.parseObject(repository.save(entity), PersonDTO.class);
		return dto;
	}
	
	public PersonDTO update(PersonDTO person, Long Id) {
		var entity = repository.findById(Id)
				.orElseThrow(()-> new ResourceNotFoundException("No records found for this ID!"));
		
		entity.setName(person.getName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		var dto = DozerMapper.parseObject(repository.save(entity), PersonDTO.class);
		
		return dto;
	}
	
	public void delete(Long Id) {
		
		Person entity = repository.findById(Id)
				.orElseThrow(()-> new ResourceNotFoundException("No records found for this ID!"));
		
		repository.delete(entity);
	}
	
}
