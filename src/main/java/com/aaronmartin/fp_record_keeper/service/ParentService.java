package com.aaronmartin.fp_record_keeper.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaronmartin.fp_record_keeper.entity.Parent;
import com.aaronmartin.fp_record_keeper.repo.ParentRepository;

@Service
@Transactional
public class ParentService {
	@Autowired
	private ParentRepository repo;

	public List<Parent> listAll() {
		return repo.findAll();
	}

	public Parent get(Integer id) {
		return repo.findById(id).get();
	}

	public void save(Parent parent) {
		repo.save(parent);
	}

	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
