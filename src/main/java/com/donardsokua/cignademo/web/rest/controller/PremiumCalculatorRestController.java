package com.donardsokua.cignademo.web.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.donardsokua.cignademo.model.Premium;
import com.donardsokua.cignademo.model.PremiumRequest;
import com.donardsokua.cignademo.service.PremiumCalculationService;

@RestController
public class PremiumCalculatorRestController {
	
	@Autowired
	private PremiumCalculationService premiumCalculationService;

	@PostMapping(value="/rest", produces = "application/json")
    public @ResponseBody Premium retrievePremium(@RequestBody  PremiumRequest request) {
        return premiumCalculationService.calculate(request);
    }

}
