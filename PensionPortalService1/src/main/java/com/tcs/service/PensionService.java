package com.tcs.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.dao.IPensionRepository;
import com.tcs.entity.PensionDetail;
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

	public Map<String, Object> calculateBankServiceCharge(PensionerDetail pensioner) {
		Map<String, Object> chargesMap = new HashMap<>();
		PensionDetail detail = new PensionDetail();
		Long calculatedAmount = 0L;
		Long bankCharges = 0L;

		bankCharges = (pensioner.getBankDetail().getIsPublic()) ? 500L : 550L;
		calculatedAmount = (pensioner.getPensionClassification().equals("F"))
				? Math.round(0.8 * Double.valueOf(pensioner.getSalaryEarned())) + Long.valueOf(pensioner.getAllowance())
				: Math.round(0.5 * Double.valueOf(pensioner.getSalaryEarned()))
						+ Long.valueOf(pensioner.getAllowance());
		detail.setBankCharges(bankCharges);
		detail.setPensionAmount(calculatedAmount);
		chargesMap.put("Pension Details for Aadhar: " + pensioner.getPan(), detail);
		return chargesMap;
	}

}
