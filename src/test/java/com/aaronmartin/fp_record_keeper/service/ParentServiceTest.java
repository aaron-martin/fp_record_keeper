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

import com.aaronmartin.fp_record_keeper.entity.Parent;
import com.aaronmartin.fp_record_keeper.repo.ParentRepository;

@ExtendWith(MockitoExtension.class)
class ParentServiceTest {
	@Mock
	ParentRepository repo;

	@InjectMocks
	ParentService service;

	@Test
	void test_list_all() {
		List<Parent> mockParentList = new ArrayList<>();
		mockParentList.add(new Parent());
		when(repo.findAll()).thenReturn(mockParentList);
		assertEquals(mockParentList, service.listAll());
	}

	@Test
	void test_get() {
		Integer mockId = Integer.valueOf(1);
		Parent mockParent = new Parent();
		when(repo.findById(mockId)).thenReturn(Optional.of(mockParent));
		assertEquals(mockParent, service.get(mockId));
	}

	@Test
	void test_save() {
		Parent mockParent = new Parent();
		service.save(mockParent);
		verify(repo).save(mockParent);
	}

	@Test
	void test_delete() {
		Integer mockId = Integer.valueOf(1);
		service.delete(mockId);
		verify(repo).deleteById(mockId);
	}

}
