package com.solvd.linkedlist.product;

public abstract class Product {
	Integer productNum;
	String uom;
	Double cost;
	Double price;
	Integer expiresInDays;
	
	public Product() {
		
	}
	
	public Product(Integer productNum, String uom, Double cost, Double price, Integer expiresInDays) {
		setProductNum(productNum);
		setUom(uom);
		setCost(cost);
		setPrice(price);
		setExpiresInDays(expiresInDays);
	}

	public Integer getProductNum() {
		return productNum;
	}

	public void setProductNum(Integer productNum) {
		this.productNum = productNum;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getExpiresInDays() {
		return expiresInDays;
	}

	public void setExpiresInDays(Integer expiresInDays) {
		this.expiresInDays = expiresInDays;
	}
	
	public Double calculateMargin() {
		return getPrice() - getCost();
	}
	
	@Override
	public String toString() {
		return getProductNum() + " - " + getExpiresInDays();
	}
}
