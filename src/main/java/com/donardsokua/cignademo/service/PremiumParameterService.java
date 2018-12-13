package com.donardsokua.cignademo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donardsokua.cignademo.model.HealthcareCriteria;
import com.donardsokua.cignademo.model.HealthcarePaymentType;
import com.donardsokua.cignademo.repository.HealthcareCriteriaRepository;
import com.donardsokua.cignademo.repository.HealthcarePaymentTypeRepository;

@Service
public class PremiumParameterService {
	@Autowired
	private HealthcareCriteriaRepository healthcareCriteriaRepository;
	
	@Autowired
	private HealthcarePaymentTypeRepository healthcarePaymentTypeRepository;
	
	public Map<Long, String> retrieveHealthcareCriterias(){
		
		Map<Long, String> criterias = new HashMap<>();
		for(HealthcareCriteria criteria: healthcareCriteriaRepository.findAll()) {
			criterias.put(criteria.getHealthcareCriteriaId(), criteria.getDescription());
		}
		return criterias;
	}
	
	public Map<Long, String> retrieveHealthcarePaymentType(){
		
		Map<Long, String> types = new HashMap<>();
		for(HealthcarePaymentType type: healthcarePaymentTypeRepository.findAll()) {
			types.put(type.getHealthcarePaymentTypeId(), type.getPaymentType());
		}
		return types;
	}
	

}
