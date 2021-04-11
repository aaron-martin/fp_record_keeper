package com.aaronmartin.fp_record_keeper.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aaronmartin.fp_record_keeper.entity.Parent;

public interface ParentRepository extends JpaRepository<Parent, Integer> {

}
