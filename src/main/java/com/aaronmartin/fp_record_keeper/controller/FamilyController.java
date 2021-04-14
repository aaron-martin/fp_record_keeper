package com.aaronmartin.fp_record_keeper.controller;

import java.util.List;
import java.util.NoSuchElementException;

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

import com.aaronmartin.fp_record_keeper.entity.Family;
import com.aaronmartin.fp_record_keeper.service.FamilyService;

@RestController
public class FamilyController {
	@Autowired
	private FamilyService service;

	@GetMapping("/families")
	public List<Family> get() {
		return service.listAll();
	}

	@GetMapping("/families/{id}")
	public ResponseEntity<Family> get(@PathVariable Integer id) {
		try {
			return new ResponseEntity<Family>(service.get(id), HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Family>(HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("/families")
	public void save(@RequestBody Family family) {
		service.save(family);
	}

	@PutMapping("/families/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Family family) {
		try {
			service.get(id);
			service.save(family);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Family>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/families/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}
