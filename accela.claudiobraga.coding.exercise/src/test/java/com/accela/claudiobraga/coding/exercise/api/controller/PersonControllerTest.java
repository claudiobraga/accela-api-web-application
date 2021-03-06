package com.accela.claudiobraga.coding.exercise.api.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import com.accela.claudiobraga.coding.exercise.repository.PersonRepository;

import io.restassured.http.ContentType;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;

@WebMvcTest
public class PersonControllerTest {
	
	@Autowired
	private PersonController personController;
	
	@MockBean
	private PersonRepository personRepository;
	
	@BeforeEach
	public void setup() {
		standaloneSetup(this.personController);
	}
	
	@Test
	public void shouldReturnSuccess_WhenGetPerson() {
		
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/persons")
		.then()
			.statusCode(HttpStatus.OK.value());
	}
	
	@Test
	public void shouldReturnNotFund_WhenGetPersonById() {
		
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/persons/{id}", 10L)
		.then()
			.statusCode(HttpStatus.NOT_FOUND.value());
	}
	
	@Test
	public void shouldReturnBadRequest_WhenAddPerson() {
		
		given()
			.accept(ContentType.JSON)
		.when()
			.post("/persons")
		.then()
			.statusCode(HttpStatus.BAD_REQUEST.value());
	}

}
