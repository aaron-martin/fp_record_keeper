package com.aaronmartin.fp_record_keeper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aaronmartin.fp_record_keeper.entity.Parent;
import com.aaronmartin.fp_record_keeper.service.ParentService;

@RestController
public class ParentController {
	@Autowired
	private ParentService service;

	@GetMapping("/parents")
	public List<Parent> get() {
		return service.listAll();
	}

	@GetMapping("/parents/{id}")
	public ResponseEntity<Parent> get(@PathVariable Integer id) {
		try {
			return new ResponseEntity<Parent>(service.get(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Parent>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/parents")
	public void save(@RequestBody Parent parent) {
		service.save(parent);
	}

	@PutMapping("/parents/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Parent parent) {
		try {
			service.get(id);
			service.save(parent);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/parents/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}
