package com.bootmongo.starter.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootmongo.starter.model.ResponseUnit;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@GetMapping(produces={"application/json", "application/xml"})
	public ResponseEntity<ResponseUnit> getTest() {
		ResponseUnit responseUnit = new ResponseUnit(200, "Tested OK!!!");
		return new ResponseEntity<ResponseUnit>(responseUnit, HttpStatus.OK);
	}
	
	@GetMapping(path="/{id}", produces={"application/json", "application/xml"})
	public ResponseEntity<ResponseUnit> getTestId(@PathVariable("id") long id) {
		ResponseUnit responseUnit = new ResponseUnit(200, "Tested OK : " + id + "!!!");
		return new ResponseEntity<ResponseUnit>(responseUnit, HttpStatus.OK);
	}
	
}
