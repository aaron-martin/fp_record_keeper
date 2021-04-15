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

import com.aaronmartin.fp_record_keeper.entity.Parent;
import com.aaronmartin.fp_record_keeper.service.ParentService;

@ExtendWith(MockitoExtension.class)
class ParentControllerTest {
	@Mock
	ParentService service;
	@InjectMocks
	ParentController controller;

	@Test
	void test_get_all() {
		List<Parent> mockParents = new ArrayList<>();
		mockParents.add(new Parent());
		when(service.listAll()).thenReturn(mockParents);
		assertEquals(mockParents, controller.get());
	}

	@Test
	void test_get_onet_success() {
		Integer mockId = Integer.valueOf(1);
		Parent mockParent = new Parent();
		when(service.get(mockId)).thenReturn(mockParent);
		ResponseEntity<Parent> expected = new ResponseEntity<>(mockParent, HttpStatus.OK);
		assertEquals(expected, controller.get(mockId));
	}

	@Test
	void test_get_one_fail() {
		Integer mockId = Integer.valueOf(1);
		when(service.get(mockId)).thenThrow(NoSuchElementException.class);
		ResponseEntity<Parent> expected = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		assertEquals(expected, controller.get(mockId));
	}

	@Test
	void test_save() {
		Parent mockParent = new Parent();
		controller.save(mockParent);
		verify(service).save(mockParent);
	}

	@Test
	void test_update_success() {
		Integer mockId = Integer.valueOf(1);
		Parent mockUpdateParent = new Parent();
		Parent originalUpdateParent = new Parent();
		when(service.get(mockId)).thenReturn(originalUpdateParent);
		ResponseEntity<?> expected = new ResponseEntity<>(HttpStatus.OK);
		assertEquals(expected, controller.update(mockId, mockUpdateParent));
		verify(service).get(mockId);
		verify(service).save(mockUpdateParent);
	}

	@Test
	void test_update_failt() {
		Integer mockId = Integer.valueOf(1);
		when(service.get(mockId)).thenThrow(NoSuchElementException.class);
		ResponseEntity<?> expected = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		assertEquals(expected, controller.update(mockId, new Parent()));
		verify(service).get(mockId);
		verify(service, never()).save(new Parent());
	}

	@Test
	void test_delete() {
		Integer mockId = Integer.valueOf(1);
		controller.delete(mockId);
		verify(service).delete(mockId);
	}
}
