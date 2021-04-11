package com.aaronmartin.fp_record_keeper.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aaronmartin.fp_record_keeper.entity.Family;

public interface FamilyRepository extends JpaRepository<Family, Integer> {

}
