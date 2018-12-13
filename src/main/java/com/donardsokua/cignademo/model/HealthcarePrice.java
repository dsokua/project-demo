package com.donardsokua.cignademo.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HealthcarePrice {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long healthcarePriceId;

	private int ageFrom;

	private int ageTo;

	private BigDecimal annualPrice;

	public Long getHealthcarePriceId() {
		return healthcarePriceId;
	}

	public void setHealthcarePriceId(Long healthcarePriceId) {
		this.healthcarePriceId = healthcarePriceId;
	}

	public int getAgeFrom() {
		return ageFrom;
	}

	public void setAgeFrom(int ageFrom) {
		this.ageFrom = ageFrom;
	}

	public int getAgeTo() {
		return ageTo;
	}

	public void setAgeTo(int ageTo) {
		this.ageTo = ageTo;
	}

	public BigDecimal getAnnualPrice() {
		return annualPrice;
	}

	public void setAnnualPrice(BigDecimal annualPrice) {
		this.annualPrice = annualPrice;
	}

}
