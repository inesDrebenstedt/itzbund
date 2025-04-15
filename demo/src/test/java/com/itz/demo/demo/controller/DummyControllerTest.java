package com.itz.demo.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itz.demo.demo.model.Dummy;
import com.itz.demo.demo.repository.DummyRepository;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@Rollback 
public class DummyControllerTest {
	
	@Autowired
	private DummyController dummyController;
	
	@Autowired
	private DummyRepository dummyRepo;
	
	@Test
	public void testeCreateDummy() {
		Dummy dummy = new Dummy();
		dummy.setName("test1");
		dummyController.createDummy(dummy);
		assertEquals(1, dummyRepo.findAll().size());
	}
	
	@Test
	public void deleteteDummy() {
		Dummy dummy = new Dummy();
		dummy.setName("test1");
		dummyController.createDummy(dummy);
		assertEquals(1, dummyRepo.findAll().size());
		dummyController.deleteDummy(dummy);
		assertEquals(0, dummyRepo.findAll().size());
	}

}
