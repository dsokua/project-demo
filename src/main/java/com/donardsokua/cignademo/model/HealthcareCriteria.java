package com.donardsokua.cignademo.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HealthcareCriteria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long healthcareCriteriaId;

	private BigDecimal factor;

	private String description;


	public Long getHealthcareCriteriaId() {
		return healthcareCriteriaId;
	}

	public void setHealthcareCriteriaId(Long healthcareCriteriaId) {
		this.healthcareCriteriaId = healthcareCriteriaId;
	}

	public BigDecimal getFactor() {
		return factor;
	}

	public void setFactor(BigDecimal factor) {
		this.factor = factor;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


}
