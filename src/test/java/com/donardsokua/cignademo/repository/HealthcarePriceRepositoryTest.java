package com.donardsokua.cignademo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HealthcarePriceRepositoryTest {

	private static final int DECIMAL = 2;
	@Autowired
	public HealthcarePriceRepository healthcarePriceRepository;
		
	@Test
	public void testFindByAge_12() {
		assertEquals(new BigDecimal("110").setScale(DECIMAL), 
				healthcarePriceRepository.findByAge(12).getAnnualPrice());		
	}

	@Test
	public void testFindByAge_15() {
		assertEquals(new BigDecimal("110").setScale(DECIMAL), 
				healthcarePriceRepository.findByAge(12).getAnnualPrice());		
	}

	@Test
	public void testFindByAge_18() {
		assertEquals(new BigDecimal("110").setScale(DECIMAL), 
				healthcarePriceRepository.findByAge(12).getAnnualPrice());		
	}
	
	@Test
	public void testFindByAge_19() {
		assertEquals(new BigDecimal("100").setScale(DECIMAL), 
				healthcarePriceRepository.findByAge(19).getAnnualPrice());		
	}

	@Test
	public void testFindByAge_23() {
		assertEquals(new BigDecimal("100").setScale(DECIMAL), 
				healthcarePriceRepository.findByAge(23).getAnnualPrice());		
	}

	@Test
	public void testFindByAge_32() {
		assertEquals(new BigDecimal("100").setScale(DECIMAL), 
				healthcarePriceRepository.findByAge(32).getAnnualPrice());		
	}
	
	@Test
	public void testFindByAge_33() {
		assertEquals(new BigDecimal("110").setScale(DECIMAL), 
				healthcarePriceRepository.findByAge(33).getAnnualPrice());		
	}

	@Test
	public void testFindByAge_36() {
		assertEquals(new BigDecimal("110").setScale(DECIMAL), 
				healthcarePriceRepository.findByAge(36).getAnnualPrice());		
	}

	@Test
	public void testFindByAge_40() {
		assertEquals(new BigDecimal("110").setScale(DECIMAL), 
				healthcarePriceRepository.findByAge(40).getAnnualPrice());		
	}
	
	@Test
	public void testFindByAge_41() {
		assertEquals(new BigDecimal("120").setScale(DECIMAL), 
				healthcarePriceRepository.findByAge(41).getAnnualPrice());		
	}

	@Test
	public void testFindByAge_46() {
		assertEquals(new BigDecimal("120").setScale(DECIMAL), 
				healthcarePriceRepository.findByAge(46).getAnnualPrice());		
	}

	@Test
	public void testFindByAge_50() {
		assertEquals(new BigDecimal("120").setScale(DECIMAL), 
				healthcarePriceRepository.findByAge(50).getAnnualPrice());		
	}
	
	@Test
	public void testFindByAge_51() {
		assertEquals(new BigDecimal("140").setScale(DECIMAL), 
				healthcarePriceRepository.findByAge(51).getAnnualPrice());		
	}

	@Test
	public void testFindByAge_60() {
		assertEquals(new BigDecimal("140").setScale(DECIMAL), 
				healthcarePriceRepository.findByAge(60).getAnnualPrice());		
	}

	@Test
	public void testFindByAge_65() {
		assertEquals(new BigDecimal("140").setScale(DECIMAL),  
				healthcarePriceRepository.findByAge(65).getAnnualPrice());		
	}

	@Test
	public void testFindByAge_11() {
		assertNull(healthcarePriceRepository.findByAge(11));;		
	}

	@Test
	public void testFindByAge_0() {
		assertNull(healthcarePriceRepository.findByAge(0));;		
	}

	@Test
	public void testFindByAge_66() {
		assertNull(healthcarePriceRepository.findByAge(66));;		
	}

}
