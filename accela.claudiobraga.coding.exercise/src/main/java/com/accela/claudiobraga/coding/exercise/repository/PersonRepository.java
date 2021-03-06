package com.accela.claudiobraga.coding.exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accela.claudiobraga.coding.exercise.domain.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}
