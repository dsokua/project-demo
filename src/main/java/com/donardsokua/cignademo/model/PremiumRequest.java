package com.donardsokua.cignademo.model;

import java.util.ArrayList;
import java.util.List;

public class PremiumRequest {
	
	private int age;
	
	private List<Long> healthcareCriteria = new ArrayList<>();
	
	private Long healthcarePaymentTypeId;
	
	public Long getHealthcarePaymentTypeId() {
		return healthcarePaymentTypeId;
	}

	public void setHealthcarePaymentTypeId(Long healthcarePaymentTypeId) {
		this.healthcarePaymentTypeId = healthcarePaymentTypeId;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Long> getHealthcareCriteria() {
		return healthcareCriteria;
	}

	public void setHealthcareCriteria(List<Long> healthcareCriteria) {
		this.healthcareCriteria = healthcareCriteria;
	}


}
