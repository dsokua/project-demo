package com.donardsokua.cignademo.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HealthcarePaymentType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long healthcarePaymentTypeId;
	
	private String paymentType;
	
	private BigDecimal multiplier;

	public Long getHealthcarePaymentTypeId() {
		return healthcarePaymentTypeId;
	}

	public void setHealthcarePaymentTypeId(Long healthcarePaymentTypeId) {
		this.healthcarePaymentTypeId = healthcarePaymentTypeId;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public BigDecimal getMultiplier() {
		return multiplier;
	}

	public void setMultiplier(BigDecimal multiplier) {
		this.multiplier = multiplier;
	}

}
