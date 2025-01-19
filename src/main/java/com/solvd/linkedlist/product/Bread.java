package com.solvd.linkedlist.product;

public class Bread extends Product {
	private String name;
	
	public Bread() {
		
	}
	
	public Bread(String name, Integer productNum, String uom, Double cost, Double price, Integer expiresInDays) {
		setName(name);
		super.setProductNum(productNum);
		super.setUom(uom);
		super.setCost(cost);
		super.setPrice(price);
		super.setExpiresInDays(expiresInDays);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return getName() + " - " + super.toString();
	}
}
