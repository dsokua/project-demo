package com.donardsokua.cignademo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.donardsokua.cignademo.model.Premium;
import com.donardsokua.cignademo.model.PremiumRequest;
import com.donardsokua.cignademo.service.PremiumCalculationService;
import com.donardsokua.cignademo.service.PremiumParameterService;

@Controller
public class PremiumCalculatorController {

	@Autowired
	private PremiumParameterService premiumParameterService;
	@Autowired
	private PremiumCalculationService premiumCalculationService;

	@GetMapping(value= {"/main", "/"})
	public String displayMain(Model model) {
		initParamters(model);
		model.addAttribute("premiumRequest", new PremiumRequest());		
		return "main";
	}
	
	@PostMapping(value="/quote")
	public String computePremium(@ModelAttribute("premiumRequest") PremiumRequest premiumRequest, Model model, BindingResult bindingResult) {
				
		boolean error = false;
		if(premiumRequest.getAge() <= 0 || premiumRequest.getAge() > 100) {
	        bindingResult.rejectValue("age", "error");
	        error = true;
		}
		
		if(error) {
			initParamters(model);
			return "main";
		}
		
		Premium premium = premiumCalculationService.calculate(premiumRequest);
		model.addAttribute("premium", premium);
		return "quote";
	}
	
	private void initParamters(Model model) {
		model.addAttribute("criterias", premiumParameterService.retrieveHealthcareCriterias());
		model.addAttribute("paymentTypes", premiumParameterService.retrieveHealthcarePaymentType());
		
	}
	
}
