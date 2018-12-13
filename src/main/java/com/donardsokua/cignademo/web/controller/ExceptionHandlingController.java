package com.donardsokua.cignademo.web.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.donardsokua.cignademo.exception.PremiumPriceException;

@ControllerAdvice
public class ExceptionHandlingController {

	
	 @ExceptionHandler(PremiumPriceException.class)
	 public String premiumPrice(Exception exception) {
		 return "assistance";
	 }
}
