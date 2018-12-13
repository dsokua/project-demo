package com.donardsokua.cignademo.repository;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

public class HealthcareCriteriaRepositoryTest {

	@Autowired
	private HealthcareCriteriaRepository healthcareCriteriaRepository;
	
	@Test
	public void testFindByHealthcareCriteriaIdIn_Existing() {
		
		List<Long> ids = new ArrayList<>();
		ids.add(1l);
		ids.add(2l);
		assertEquals(2, healthcareCriteriaRepository.findByHealthcareCriteriaIdIn(ids).size());
	}
	
	@Test
	public void testFindByHealthcareCriteriaIdIn_NotExisting() {
		List<Long> ids = new ArrayList<>();
		ids.add(-1l);
		assertEquals(0, healthcareCriteriaRepository.findByHealthcareCriteriaIdIn(ids).size());
		
		
	}
	
	
}
