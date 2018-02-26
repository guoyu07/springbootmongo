package com.bootmongo.starter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.bootmongo.starter.model.ResponseUnit;
import com.bootmongo.starter.model.Todo;
import com.bootmongo.starter.repository.TodoRespository;

@RestController
@RequestMapping("/todos")
public class TodoController {

	@Autowired
	private TodoRespository todoRespository;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
		return new ResponseEntity<Todo>(todoRespository.save(todo), HttpStatus.CREATED);
	}

	@PostMapping(path = "/bulk", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Todo>> createTodos(@RequestBody List<Todo> todos) {
		return new ResponseEntity<List<Todo>>(todoRespository.save(todos), HttpStatus.CREATED);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Todo>> getTodos() {
		return new ResponseEntity<List<Todo>>(todoRespository.findAll(), HttpStatus.OK);
	}

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Todo> getTodoById(@PathVariable("id") int id) {
		return new ResponseEntity<Todo>(todoRespository.findOne(id), HttpStatus.OK);
	}

	@GetMapping(value = "/user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Todo>> getTodosByUserId(@PathVariable("userId") String userId) {
		return new ResponseEntity<List<Todo>>(todoRespository.findByUserId(userId), HttpStatus.OK);
	}

	@GetMapping(value = "/user/{userId}/{status}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Todo>> getTodosByUserAndStatus(@PathVariable("userId") String userId,
			@PathVariable("status") String status) {
		return new ResponseEntity<List<Todo>>(todoRespository.findByUserAndStatus(userId, status), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Todo> updateTodo(@RequestBody Todo todo) {
		return new ResponseEntity<Todo>(todoRespository.save(todo), HttpStatus.ACCEPTED);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ResponseUnit> deleteTodo(@PathVariable("id") int id) {
		try {
			todoRespository.delete(id);
		} catch (Exception ex) {
			return new ResponseEntity<ResponseUnit>(new ResponseUnit(500, "Sorry!!! Internal Server Error!!!"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<ResponseUnit>(
				new ResponseUnit(204, "Record with id : " + id + " Deleted Successfully!!!"), HttpStatus.NO_CONTENT);
	}

}
