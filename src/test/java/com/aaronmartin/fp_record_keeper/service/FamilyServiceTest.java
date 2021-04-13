package com.aaronmartin.fp_record_keeper.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.aaronmartin.fp_record_keeper.entity.Family;
import com.aaronmartin.fp_record_keeper.repo.FamilyRepository;

@ExtendWith(MockitoExtension.class)
class FamilyServiceTest {
	@Mock
	FamilyRepository repo;

	@InjectMocks
	FamilyService service;

	@Test
	void test_list_all() {
		List<Family> familyList = new ArrayList<>();
		familyList.add(new Family());
		when(repo.findAll()).thenReturn(familyList);
		assertEquals(familyList, service.listAll());
	}

	@Test
	void test_get() {
		Integer mockId = Integer.valueOf(1);
		Family mockFamily = new Family();
		when(repo.findById(mockId)).thenReturn(Optional.of(mockFamily));
		assertEquals(mockFamily, service.get(mockId));
	}

	@Test
	void test_save() {
		Family mockFamily = new Family();
		service.save(mockFamily);
		verify(repo).save(mockFamily);
	}

	@Test
	void test_delete() {
		Integer mockId = Integer.valueOf(1);
		service.delete(mockId);
		verify(repo).deleteById(mockId);
	}
}
