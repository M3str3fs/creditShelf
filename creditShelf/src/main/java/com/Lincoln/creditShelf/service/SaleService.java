package com.Lincoln.creditShelf.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jca.cci.RecordTypeNotSupportedException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Lincoln.creditShelf.repository.SaleRepository;
import com.Lincoln.creditShelf.entity.SaleEntity;

@Service
public class SaleService {

	@Autowired
	SaleRepository repository;

	public List<SaleEntity> registerCsvFiles(MultipartFile multipartFile) throws IOException {

		return new ArrayList<SaleEntity>();
	}

	public List<SaleEntity> getAllSales() {
		List<SaleEntity> salesList = repository.findAll();

		if (salesList.size() > 0) {
			return salesList;
		} else {
			return new ArrayList<SaleEntity>();
		}
	}

	public SaleEntity getSalesById(Long id) throws Exception {
		Optional<SaleEntity> sales = repository.findById(id);

		if (sales.isPresent()) {
			return sales.get();
		} else {
			throw new Exception("No employee record exist for given id");
		}
	}

	public SaleEntity createOrUpdateSales(CSVRecord csvRecord) throws Exception {

		SaleEntity sale = new SaleEntity();
		sale.setCompany(csvRecord.get(0));
		sale.setOrderDate(csvRecord.get(1));
		sale.setOrderNumber(csvRecord.get(2));
		sale.setProductId(csvRecord.get(3));
		sale.setQuantity(csvRecord.get(4));
		sale.setCurrency(csvRecord.get(5));

		sale = repository.save(sale);

		return sale;

		
	}

	public void deleteSalesById(Long id) throws Exception {
		Optional<SaleEntity> sales = repository.findById(id);

		if (sales.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new Exception("No employee record exist for given id");
		}
	}
}
