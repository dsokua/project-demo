package com.donardsokua.cignademo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.util.reflection.FieldSetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.donardsokua.cignademo.exception.PremiumPriceException;
import com.donardsokua.cignademo.model.HealthcareCriteria;
import com.donardsokua.cignademo.model.HealthcarePaymentType;
import com.donardsokua.cignademo.model.HealthcarePrice;
import com.donardsokua.cignademo.model.Premium;
import com.donardsokua.cignademo.model.PremiumRequest;
import com.donardsokua.cignademo.repository.HealthcareCriteriaRepository;
import com.donardsokua.cignademo.repository.HealthcarePaymentTypeRepository;
import com.donardsokua.cignademo.repository.HealthcarePriceRepository;

@RunWith(SpringRunner.class)
@SpringBootTest

public class PremiumCalculationServiceMockTest {
	private static final int DECIMAL = 2;

	@Autowired
	private PremiumCalculationService premiumCalculationService;
	
	@Test
	public void testWithPrice_NoFactor_Annual() throws NoSuchFieldException, SecurityException {
		int age = 18;
		long healthcarePaymentTypeId = 8l;
		
		
		HealthcarePriceRepository healthcarePriceRepository = mock(HealthcarePriceRepository.class);
		HealthcarePrice healthcarePrice = new HealthcarePrice();
		healthcarePrice.setAnnualPrice(new BigDecimal("100"));		
		when(healthcarePriceRepository.findByAge(age)).thenReturn(healthcarePrice);
		FieldSetter.setField(premiumCalculationService, 
				premiumCalculationService.getClass()
					.getDeclaredField("healthcarePriceRepository"), 
						healthcarePriceRepository);
		
		
		HealthcareCriteriaRepository healthcareCriteriaRepository = mock(HealthcareCriteriaRepository.class);
		List<Long> list = new ArrayList<>();
		when(healthcareCriteriaRepository.findByHealthcareCriteriaIdIn(list)).thenReturn(new ArrayList<>());
		FieldSetter.setField(premiumCalculationService, 
				premiumCalculationService.getClass()
					.getDeclaredField("healthcareCriteriaRepository"), 
						healthcareCriteriaRepository);
		
		
		
		HealthcarePaymentTypeRepository healthcarePaymentTypeRepository = mock(HealthcarePaymentTypeRepository.class);
		HealthcarePaymentType healthcarePaymentType = new HealthcarePaymentType();
		healthcarePaymentType.setMultiplier(BigDecimal.ONE);
		
		Optional<HealthcarePaymentType> healthcarePaymentTypes = Optional.of(healthcarePaymentType);
		when(healthcarePaymentTypeRepository.findById(8l)).thenReturn(healthcarePaymentTypes);
		FieldSetter.setField(premiumCalculationService, 
				premiumCalculationService.getClass()
					.getDeclaredField("healthcarePaymentTypeRepository"), 
						healthcarePaymentTypeRepository);
		
		


		PremiumRequest request = new PremiumRequest();
		request.setAge(age);
		request.setHealthcarePaymentTypeId(healthcarePaymentTypeId);
		Premium premium = premiumCalculationService.calculate(request);

		assertEquals(new BigDecimal("100").setScale(DECIMAL), premium.getRate());
	}
	
	@Test
	public void testWithPrice_1Factor_SemiAnnual() throws NoSuchFieldException, SecurityException {
		int age = 18;
		long healthcarePaymentTypeId = 8l;
		List<Long> list = new ArrayList<>();
		list.add(1l);
		
		
		HealthcarePriceRepository healthcarePriceRepository = mock(HealthcarePriceRepository.class);
		HealthcarePrice healthcarePrice = new HealthcarePrice();
		healthcarePrice.setAnnualPrice(new BigDecimal("120"));		
		when(healthcarePriceRepository.findByAge(age)).thenReturn(healthcarePrice);
		FieldSetter.setField(premiumCalculationService, 
				premiumCalculationService.getClass()
					.getDeclaredField("healthcarePriceRepository"), 
						healthcarePriceRepository);
		
		
		HealthcareCriteriaRepository healthcareCriteriaRepository = mock(HealthcareCriteriaRepository.class);
		HealthcareCriteria healthcareCriteria = new HealthcareCriteria();
		healthcareCriteria.setFactor(new BigDecimal("0.04"));
		
		List<HealthcareCriteria> healthcareCriterias = new ArrayList<>();
		healthcareCriterias.add(healthcareCriteria);
		
		when(healthcareCriteriaRepository.findByHealthcareCriteriaIdIn(list)).thenReturn(healthcareCriterias);
		FieldSetter.setField(premiumCalculationService, 
				premiumCalculationService.getClass()
					.getDeclaredField("healthcareCriteriaRepository"), 
						healthcareCriteriaRepository);
		
		
		
		HealthcarePaymentTypeRepository healthcarePaymentTypeRepository = mock(HealthcarePaymentTypeRepository.class);
		HealthcarePaymentType healthcarePaymentType = new HealthcarePaymentType();
		healthcarePaymentType.setMultiplier(new BigDecimal(".7"));
		
		Optional<HealthcarePaymentType> healthcarePaymentTypes = Optional.of(healthcarePaymentType);
		when(healthcarePaymentTypeRepository.findById(8l)).thenReturn(healthcarePaymentTypes);
		FieldSetter.setField(premiumCalculationService, 
				premiumCalculationService.getClass()
					.getDeclaredField("healthcarePaymentTypeRepository"), 
						healthcarePaymentTypeRepository);
		

		PremiumRequest request = new PremiumRequest();
		request.setAge(age);
		request.setHealthcarePaymentTypeId(healthcarePaymentTypeId);
		request.setHealthcareCriteria(list);
		Premium premium = premiumCalculationService.calculate(request);

		assertEquals(new BigDecimal("87.36").setScale(DECIMAL), premium.getRate());
	}
	
	@Test(expected=PremiumPriceException.class)
	public void testWithNoPrice_NoFactor_Annual() throws NoSuchFieldException, SecurityException {
		int age = 90;
		long healthcarePaymentTypeId = 8l;
		
		
		HealthcarePriceRepository healthcarePriceRepository = mock(HealthcarePriceRepository.class);
		when(healthcarePriceRepository.findByAge(age)).thenReturn(null);
		FieldSetter.setField(premiumCalculationService, 
				premiumCalculationService.getClass()
					.getDeclaredField("healthcarePriceRepository"), 
						healthcarePriceRepository);
		
		
		HealthcareCriteriaRepository healthcareCriteriaRepository = mock(HealthcareCriteriaRepository.class);
		List<Long> list = new ArrayList<>();
		when(healthcareCriteriaRepository.findByHealthcareCriteriaIdIn(list)).thenReturn(new ArrayList<>());
		FieldSetter.setField(premiumCalculationService, 
				premiumCalculationService.getClass()
					.getDeclaredField("healthcareCriteriaRepository"), 
						healthcareCriteriaRepository);
		
		
		
		HealthcarePaymentTypeRepository healthcarePaymentTypeRepository = mock(HealthcarePaymentTypeRepository.class);
		HealthcarePaymentType healthcarePaymentType = new HealthcarePaymentType();
		healthcarePaymentType.setMultiplier(BigDecimal.ONE);
		
		Optional<HealthcarePaymentType> healthcarePaymentTypes = Optional.of(healthcarePaymentType);
		when(healthcarePaymentTypeRepository.findById(8l)).thenReturn(healthcarePaymentTypes);
		FieldSetter.setField(premiumCalculationService, 
				premiumCalculationService.getClass()
					.getDeclaredField("healthcarePaymentTypeRepository"), 
						healthcarePaymentTypeRepository);
		
		


		PremiumRequest request = new PremiumRequest();
		request.setAge(age);
		request.setHealthcarePaymentTypeId(healthcarePaymentTypeId);
		premiumCalculationService.calculate(request);
		
		fail();

	}
}
