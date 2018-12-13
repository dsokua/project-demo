package com.donardsokua.cignademo.service;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.donardsokua.cignademo.model.HealthcareCriteria;
import com.donardsokua.cignademo.model.HealthcarePaymentType;
import com.donardsokua.cignademo.model.HealthcarePrice;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PremiumCalculationServiceTest {

	private static final int DECIMAL = 2;
	@Autowired
	private PremiumCalculationService premiumCalculationService;
	
	@Test
	public void testPrice_NoFactor_Annual() {
		String[] factors = {};
		assertEquals(new BigDecimal("100").setScale(DECIMAL), 
			premiumCalculationService.calculate(createHealthcarePrice("100"),
					createHealthcareCriterias( factors),
					createHealthcarePaymentType("1"))
				);
	}
	
	@Test
	public void testPrice_1Factor_Annual() {
		String[] factors = {"0.02"};
		assertEquals(new BigDecimal("102").setScale(DECIMAL), 
			premiumCalculationService.calculate(createHealthcarePrice("100"),
					createHealthcareCriterias( factors),
					createHealthcarePaymentType("1"))
				);		
	}
	
	@Test
	public void testPrice_2Factors_Annual() {
		String[] factors = {"0.02", "0.1"};
		assertEquals(new BigDecimal("125.44").setScale(DECIMAL), 
			premiumCalculationService.calculate(createHealthcarePrice("112"),
					createHealthcareCriterias( factors),
					createHealthcarePaymentType("1"))
				);		
	}
	
	@Test
	public void testPrice_NoFactor_SemiAnnual() {
		String[] factors = {};
		assertEquals(new BigDecimal("60").setScale(DECIMAL), 
			premiumCalculationService.calculate(createHealthcarePrice("100"),
					createHealthcareCriterias( factors),
					createHealthcarePaymentType(".60"))
				);

	}
	
	@Test
	public void testPrice_1Factor_SemiAnnual() {
		String[] factors = {".03"};
		assertEquals(new BigDecimal("61.8").setScale(DECIMAL), 
			premiumCalculationService.calculate(createHealthcarePrice("100"),
					createHealthcareCriterias( factors),
					createHealthcarePaymentType(".60"))
				);
		
	}
	
	@Test
	public void testPrice_2Factors_SemiAnnual() {
		String[] factors = {".03", "0.20"};
		assertEquals(new BigDecimal("73.8").setScale(DECIMAL), 
			premiumCalculationService.calculate(createHealthcarePrice("100"),
					createHealthcareCriterias( factors),
					createHealthcarePaymentType(".60"))
				);
		
	}
	
	@Test
	public void testPrice_NoFactor_Quarter() {
		String[] factors = {};
		assertEquals(new BigDecimal("40").setScale(DECIMAL), 
			premiumCalculationService.calculate(createHealthcarePrice("100"),
					createHealthcareCriterias( factors),
					createHealthcarePaymentType(".40"))
				);

	}
	
	@Test
	public void testPrice_1Factor_Quarter() {
		String[] factors = {".13333"};
		assertEquals(new BigDecimal("45.33").setScale(DECIMAL), 
			premiumCalculationService.calculate(createHealthcarePrice("100"),
					createHealthcareCriterias( factors),
					createHealthcarePaymentType(".40"))
				);
		
	}
	
	@Test
	public void testPrice_2Factors_Quarter() {
		String[] factors = {".278", ".780"};
		assertEquals(new BigDecimal("82.32").setScale(DECIMAL), 
			premiumCalculationService.calculate(createHealthcarePrice("100"),
					createHealthcareCriterias( factors),
					createHealthcarePaymentType(".40"))
				);
		
	}
	
	@Test
	public void testPrice_NoFactor_Monthly() {
		String[] factors = {};
		assertEquals(new BigDecimal("20").setScale(DECIMAL), 
			premiumCalculationService.calculate(createHealthcarePrice("100"),
					createHealthcareCriterias( factors),
					createHealthcarePaymentType(".20"))
				);
		
	}
	
	@Test
	public void testPrice_1Factor_Monthly() {
		String[] factors = {".68"};
		assertEquals(new BigDecimal("33.6").setScale(DECIMAL), 
			premiumCalculationService.calculate(createHealthcarePrice("100"),
					createHealthcareCriterias( factors),
					createHealthcarePaymentType(".20"))
				);
		
	}
	
	@Test
	public void testPrice_2Factors_Monthly() {
		String[] factors = {"1", "2.33333"};
		assertEquals(new BigDecimal("86.67").setScale(DECIMAL), 
			premiumCalculationService.calculate(createHealthcarePrice("100"),
					createHealthcareCriterias( factors),
					createHealthcarePaymentType(".20"))
				);
		
	}

	private HealthcarePrice createHealthcarePrice(String price) {
		HealthcarePrice healthcarePrice = new HealthcarePrice();
		healthcarePrice.setAnnualPrice(new BigDecimal(price));
		return healthcarePrice;
	}
	
	private List<HealthcareCriteria> createHealthcareCriterias(String[] criteria){
		List<HealthcareCriteria> list = new ArrayList<>();
		for(String s: criteria) {
			HealthcareCriteria healthcareCriteria = new HealthcareCriteria();
			healthcareCriteria.setFactor(new BigDecimal(s));
			list.add(healthcareCriteria);
		}
		
		return list;
	}
	
	
	private Optional<HealthcarePaymentType> createHealthcarePaymentType(String multiplier) {
		Optional<HealthcarePaymentType> healthcarePaymentType = Optional.of(new HealthcarePaymentType());
		healthcarePaymentType.get().setMultiplier(new BigDecimal(multiplier));
		return healthcarePaymentType;
	}
	
 

	
}
