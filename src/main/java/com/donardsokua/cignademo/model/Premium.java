package com.donardsokua.cignademo.model;

import java.math.BigDecimal;

public class Premium {

	private BigDecimal rate;
	
	private String paymentType;

	public Premium(BigDecimal rate, String paymentType) {
		this.rate = rate;
		this.paymentType = paymentType;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	
}
