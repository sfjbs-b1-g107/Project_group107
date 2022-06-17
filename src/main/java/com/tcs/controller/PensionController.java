package com.tcs.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.tcs.dao.IPensionRepository;
import com.tcs.entity.BankDetail;
import com.tcs.entity.PensionerDetail;




@Controller
public class PensionController {
	
	@Autowired
	private IPensionRepository repository;
	
	@RequestMapping(value ="/load")	
	public String loadDataFromCSV() throws IOException {
		
		 CSVReader reader=
                 new CSVReaderBuilder(new FileReader("src/main/resources/import.csv")).
                         build();
		 List<PensionerDetail> csv_objectList=reader.readAll().stream().map(data-> {
			 PensionerDetail csvObject= new PensionerDetail();
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
		 repository.saveAll(csv_objectList);
         
		return "Success";
	}

}
