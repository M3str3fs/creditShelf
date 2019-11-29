package com.Lincoln.creditShelf.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.Lincoln.creditShelf.entity.CompanyEntity;
import com.Lincoln.creditShelf.service.CompanyService;
import com.Lincoln.creditShelf.service.SaleService;

@RestController
@RequestMapping("/sales")
public class SaleController {

	@Autowired
	public SaleService    saleService;
	public CompanyService companyService;

	@PostMapping("/upload")
	public HttpStatus salesFileUpload(@RequestParam("file") MultipartFile file) throws Exception {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
			CSVParser csvParser = new CSVParser(reader,
					CSVFormat.DEFAULT.withHeader().withIgnoreHeaderCase().withTrim());

			for (CSVRecord csvRecord : csvParser) {
				saleService.createOrUpdateSales(csvRecord);
//				List<CompanyEntity> companyList = companyService.getAllCompanys();
//				if (!companyList.contains(csvRecord.get(0)))
//				companyService.createOrUpdateCompany(csvRecord);
			}
			
		} catch (Exception e) {
			return HttpStatus.BAD_REQUEST;
		}
		return HttpStatus.OK;
	}
}