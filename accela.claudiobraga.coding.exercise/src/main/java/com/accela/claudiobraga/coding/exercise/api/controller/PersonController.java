package com.accela.claudiobraga.coding.exercise.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.accela.claudiobraga.coding.exercise.domain.Person;
import com.accela.claudiobraga.coding.exercise.repository.PersonRepository;

@RestController
@RequestMapping("/persons")
public class PersonController {
	
	@Autowired
	private PersonRepository personRepository;
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public Person add(@Valid @RequestBody Person person) {
		return personRepository.save(person);
	}
	
	@GetMapping()
	public List<Person> toList(){
		return personRepository.findAll();
	}
	
	@GetMapping("/count")
	public String countPerson(){
		List<Person> allPersons = personRepository.findAll();
		
		return "Amount of Person " + allPersons.size();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Person> getById(@Valid @PathVariable Long id){
		Optional<Person> person = personRepository.findById(id);
		
		if (person.isPresent()) {
			return ResponseEntity.ok(person.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Person> edit (@Valid @PathVariable Long id, @RequestBody Person person) {
		if(!personRepository.existsById(id)) {
		return ResponseEntity.notFound().build();
		}
		person.setId(id);
		person = personRepository.save(person);
		return ResponseEntity.ok(person);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> remove (@PathVariable Long id){
		if(!personRepository.existsById(id)) {
		return ResponseEntity.notFound().build();
		}
		
		personRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
