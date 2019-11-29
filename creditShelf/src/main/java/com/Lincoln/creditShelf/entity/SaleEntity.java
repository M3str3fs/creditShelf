package com.Lincoln.creditShelf.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_SALE")
public class SaleEntity {
	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "company")
	private String company;

	@Column(name = "order_date")
	private String orderDate;

	@Column(name = "order_number")
	private String orderNumber;

	@Column(name = "product_id")
	private String productId;

	@Column(name = "quantity")
	private String quantity;

	@Column(name = "sale_price")
	private String salePrice;

	@Column(name = "currency")
	private String currency;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCompany(String company) {
		return company;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getSalePrice() {
		return salePrice;
	}
	
	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
	}
	
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	

	// Setters and getters

}
