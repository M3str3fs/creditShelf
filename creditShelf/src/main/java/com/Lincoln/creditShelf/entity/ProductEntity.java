package com.Lincoln.creditShelf.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_PRODUCT")
public class ProductEntity {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "Prod_Id")
	private String productId;
	
	@Column(name = "Product_Name")
	private String productName;

	@Column(name = "Build_Cost")
	private String buildCost;

	@Column(name = "currency")
	private String currency;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getBuildCost() {
		return buildCost;
	}

	public void setBuildCost(String buildCost) {
		this.buildCost = buildCost;
	}
	
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}


}
