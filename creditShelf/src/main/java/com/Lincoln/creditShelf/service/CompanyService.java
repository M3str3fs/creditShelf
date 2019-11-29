package com.Lincoln.creditShelf.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Lincoln.creditShelf.entity.CompanyEntity;
import com.Lincoln.creditShelf.repository.CompanyRepository;


@Service
public class CompanyService {
	@Autowired
	CompanyRepository repository;
	
	public void createOrUpdateCompany(CSVRecord csvRecord) throws Exception {
		try {
		CompanyEntity company = new CompanyEntity();
		company.setCompanyName(csvRecord.get(0));
		company = repository.save(company);

		
		}catch(Exception e) {
			System.out.print(e);
		}
		
	}
	
	public List<CompanyEntity> getAllCompanys() {
		List<CompanyEntity> companysList = repository.findAll();
		System.out.println(companysList);
		return companysList;
//		if (companysList.size() > 0) {
//			return companysList;
//		} else {
//			return 
//		}
	}
}


