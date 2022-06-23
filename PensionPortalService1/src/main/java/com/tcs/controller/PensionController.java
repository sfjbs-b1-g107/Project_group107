package com.tcs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.entity.PensionerDetail;
import com.tcs.service.PensionService;

@RestController
public class PensionController {
	
	@Autowired
	private PensionService service;
	
	@PostMapping(value = "/pensionservice1/ProcessPension/{id}")
	public ResponseEntity<Object> getPensionerDetailByPAN(@PathVariable String id) {
		System.out.println(id);
		PensionerDetail pensioner = service.fetchPensionerDetailsByPAN(id);
		if(pensioner == null) {
			return new ResponseEntity<Object>("Invalid pensioner detail provided, please provide valid detail.",HttpStatus.UNAUTHORIZED);
		}
		
		
		return new ResponseEntity<Object>(service.calculateBankServiceCharge(pensioner),HttpStatus.ACCEPTED);
	}
	
}
