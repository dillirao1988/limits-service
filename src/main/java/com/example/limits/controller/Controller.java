package com.example.limits.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.limits.config.myConfiguration;
import com.example.limits.model.Limits;

@RestController
@RequestMapping("limits")
public class Controller {
	
	/*@Value("${limits-service.minimum}")
	int configuredMinLimit;
	
	@Value("${limits-service.maximum}")
	int configuredMaxLimit;*/
	
	@Autowired
	private myConfiguration myConfig;

	@GetMapping
	public ResponseEntity<Limits> getLimits(){
		
		Limits limit = new Limits();
		limit.setMaximumLimit(myConfig.getMaximum());
		limit.setMinimumLimit(myConfig.getMinimum());
		
		return new ResponseEntity<Limits>(limit,HttpStatus.OK);
	}
}
