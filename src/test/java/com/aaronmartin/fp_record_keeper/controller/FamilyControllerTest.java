package com.aaronmartin.fp_record_keeper.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.aaronmartin.fp_record_keeper.entity.Family;
import com.aaronmartin.fp_record_keeper.service.FamilyService;

@ExtendWith(MockitoExtension.class)
class FamilyControllerTest {
	@Mock
	FamilyService service;

	@InjectMocks
	FamilyController controller;

	@Test
	void test_get_all() {
		List<Family> familyList = new ArrayList<>();
		familyList.add(new Family());
		when(service.listAll()).thenReturn(familyList);
		assertEquals(familyList, controller.get());
	}

	@Test
	void test_get_one() {
		Integer mockId = Integer.valueOf(1);
		Family mockFamily = new Family();
		when(service.get(mockId)).thenReturn(mockFamily);
		ResponseEntity<Family> result = controller.get(mockId);
		assertEquals(result, new ResponseEntity<Family>(mockFamily, HttpStatus.OK));
	}

	@Test
	void test_get_one_fail() {
		Integer mockId = Integer.valueOf(1);
		when(service.get(mockId)).thenThrow(NoSuchElementException.class);
		ResponseEntity<Family> result = controller.get(mockId);
		assertEquals(result, new ResponseEntity<Family>(HttpStatus.NOT_FOUND));
	}

	@Test
	void test_save() {
		Family mockFamily = new Family();
		controller.save(mockFamily);
		verify(service).save(mockFamily);
	}

	@Test
	void test_update() {
		Integer mockId = Integer.valueOf(1);
		Family mockFamily = new Family();
		Family mockFamilyOriginal = new Family();
		when(service.get(mockId)).thenReturn(mockFamilyOriginal);
		ResponseEntity<?> result = controller.update(mockId, mockFamily);
		assertEquals(result, new ResponseEntity<>(HttpStatus.OK));
		verify(service).get(mockId);
		verify(service).save(mockFamily);
	}

	@Test
	void test_update_fail() {
		Integer mockId = Integer.valueOf(1);
		Family mockFamily = new Family();
		when(service.get(mockId)).thenThrow(NoSuchElementException.class);
		ResponseEntity<?> result = controller.update(mockId, mockFamily);
		assertEquals(result, new ResponseEntity<>(HttpStatus.NOT_FOUND));
		verify(service).get(mockId);
		verify(service, never()).save(mockFamily);
	}
}
