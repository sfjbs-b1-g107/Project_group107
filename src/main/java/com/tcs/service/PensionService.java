package com.tcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.dao.IPensionRepository;
import com.tcs.entity.PensionerDetail;

@Service
public class PensionService {
	
	@Autowired
	private IPensionRepository repository;
	

	public void savePensioners(List<PensionerDetail> csv_objectList) {
		repository.saveAll(csv_objectList);
		
	}


	public PensionerDetail fetchPensionerDetailsByPAN(String id) {
		return repository.findBypan(id);
		
	}


	public List<PensionerDetail> getPensionerDetailByName(String name) {
		return repository.findByname(name);	
		
	}

}
