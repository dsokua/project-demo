package com.donardsokua.cignademo.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donardsokua.cignademo.exception.PremiumPriceException;
import com.donardsokua.cignademo.model.HealthcareCriteria;
import com.donardsokua.cignademo.model.HealthcarePaymentType;
import com.donardsokua.cignademo.model.HealthcarePrice;
import com.donardsokua.cignademo.model.Premium;
import com.donardsokua.cignademo.model.PremiumRequest;
import com.donardsokua.cignademo.repository.HealthcareCriteriaRepository;
import com.donardsokua.cignademo.repository.HealthcarePaymentTypeRepository;
import com.donardsokua.cignademo.repository.HealthcarePriceRepository;

@Service
public class PremiumCalculationService {

	private static final int DECIMAL = 2;
	
	@Autowired
	private HealthcareCriteriaRepository healthcareCriteriaRepository;
	
	@Autowired
	private HealthcarePaymentTypeRepository healthcarePaymentTypeRepository;
	
	@Autowired
	private HealthcarePriceRepository healthcarePriceRepository;
	
	public Premium calculate(PremiumRequest premiumRequest) {
		
		HealthcarePrice healthcarePrice = healthcarePriceRepository.findByAge(premiumRequest.getAge());
		
		if(healthcarePrice == null) {
			throw new PremiumPriceException();
		}
		List<HealthcareCriteria> healthcareCriterias = 
				healthcareCriteriaRepository.findByHealthcareCriteriaIdIn(premiumRequest.getHealthcareCriteria());

		Optional<HealthcarePaymentType> healthcarePaymentType = healthcarePaymentTypeRepository.findById(premiumRequest.getHealthcarePaymentTypeId());

		BigDecimal rate = calculate(healthcarePrice, healthcareCriterias, healthcarePaymentType);
		return new Premium(rate, healthcarePaymentType.get().getPaymentType());		
	}
	
	public BigDecimal calculate(HealthcarePrice healthcarePrice, List<HealthcareCriteria> healthcareCriterias, Optional<HealthcarePaymentType> healthcarePaymentType) {
		
		BigDecimal rate = healthcarePrice.getAnnualPrice().multiply(healthcarePaymentType.get().getMultiplier());
		
		BigDecimal factor = BigDecimal.ZERO;
		for(HealthcareCriteria criteria: healthcareCriterias) {
			factor = factor.add(criteria.getFactor());
		}
		
		rate = rate.multiply(BigDecimal.ONE.add(factor));
		rate = rate.setScale(DECIMAL, RoundingMode.HALF_UP);
		
		return rate;
	}
}
