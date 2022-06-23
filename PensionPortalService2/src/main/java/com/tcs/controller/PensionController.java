package com.tcs.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.tcs.entity.BankDetail;
import com.tcs.entity.PensionerDetail;
import com.tcs.service.PensionService;

@RestController
public class PensionController {
	
	@Autowired
	private PensionService service;

	/**
	 * @author Pooja.varshney
	 * @return String denoting success message
	 * @throws IOException if exception occurs during parsing csv
	 */
	@RequestMapping(value = "/pensionservice2/load", method = RequestMethod.GET)
	public String loadDataFromCSV() throws IOException {

		CSVReader reader = new CSVReaderBuilder(new FileReader("src/main/resources/import.csv")).build();
		List<PensionerDetail> csv_objectList = reader.readAll().stream().map(data -> {
			PensionerDetail csvObject = new PensionerDetail();
			csvObject.setName(data[0]);
			csvObject.setDob(data[1]);
			csvObject.setPan(data[2]);
			csvObject.setSalaryEarned(data[3]);
			csvObject.setAllowance(data[4]);
			csvObject.setPensionClassification(data[5]);

			BankDetail obj = new BankDetail();
			obj.setBankName(data[6]);
			obj.setAccountNumber(data[7]);
			obj.setIsPublic(Boolean.valueOf(data[8]));
			csvObject.setBankDetail(obj);
			return csvObject;
		}).collect(Collectors.toList());
		service.savePensioners(csv_objectList);
//		repository.saveAll(csv_objectList);

		return "Data Uploaded to H2 Successfully";
	}
	
	/**
	 * @author Pooja.varshney
	 * @param id Aadhar/pan id
	 * @return PensionerDetail entity
	 */
	@RequestMapping(value = "/pensionservice2/PensionerDetailByAadhaar/{id}", method = RequestMethod.GET)
	public PensionerDetail getPensionerDetailByPAN(@PathVariable String id) {
		System.out.println(id);

		return service.fetchPensionerDetailsByPAN(id);
	}

	/**
	 * @author Pooja.varshney
	 * @param name
	 * @return
	 * This method is added for practice.
	 */
	@RequestMapping(value = "/pensionservice2/PensionerDetailByName/{name}", method = RequestMethod.GET)
	public List<PensionerDetail> getPensionerDetailByName(@PathVariable String name) {
		System.out.println(name);
		return service.getPensionerDetailByName(name);
	}

}
