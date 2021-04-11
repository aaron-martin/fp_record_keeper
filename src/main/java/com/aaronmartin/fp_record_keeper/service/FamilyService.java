package com.aaronmartin.fp_record_keeper.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaronmartin.fp_record_keeper.entity.Family;
import com.aaronmartin.fp_record_keeper.repo.FamilyRepository;

@Service
@Transactional
public class FamilyService {
	@Autowired
	private FamilyRepository repo;

	public List<Family> listAll() {
		return repo.findAll();
	}

	public Family get(Integer id) {
		return repo.findById(id).get();
	}

	public void save(Family family) {
		repo.save(family);
	}

	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
