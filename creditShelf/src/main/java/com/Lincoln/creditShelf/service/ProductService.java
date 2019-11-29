package com.Lincoln.creditShelf.service;

import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Lincoln.creditShelf.entity.ProductEntity;
import com.Lincoln.creditShelf.repository.ProductRepository;


@Service
public class ProductService {
	
	@Autowired
	ProductRepository repository;
	
	public ProductEntity createOrUpdateProduct(CSVRecord csvRecord) throws Exception {

		ProductEntity product = new ProductEntity();
		product.setProductName(csvRecord.get(0));
		product.setBuildCost(csvRecord.get(1));
		product.setCurrency(csvRecord.get(2));
		product.setProductId(csvRecord.get(3));
		
		product = repository.save(product);

		return product;

		
	}
}
