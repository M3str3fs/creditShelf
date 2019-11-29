package com.Lincoln.creditShelf.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

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


import com.Lincoln.creditShelf.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	public ProductService productService;
	
	@PostMapping("/upload")
	public HttpStatus productsFileUpload(@RequestParam("file") MultipartFile file) throws Exception {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
			CSVParser csvParser = new CSVParser(reader,
					CSVFormat.DEFAULT.withHeader().withIgnoreHeaderCase().withTrim());

			for (CSVRecord csvRecord : csvParser) {
				productService.createOrUpdateProduct(csvRecord);
			}

		} catch (Exception e) {
			return HttpStatus.BAD_REQUEST;
		}
		return HttpStatus.OK;
	}

}
