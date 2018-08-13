package com.rentals.domain;

import com.wf.domain.Rentee;
import com.wf.domain.annotation.Attendant;

@Attendant
public class Customer extends Rentee {
	private String number;
	
	public Customer() {
		super();
	}
	
	public Customer(String number) {
		super();
		this.number = number;
	}
	
	public Customer(String code, String name, String number) {
		super();
		this.setCode(code);
		this.setName(name);
		this.setNumber(number);
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public Customer clone() {
		Customer customer = new Customer();
		customer.setCode(this.getCode());
		customer.setNumber(this.number);
		customer.setName(this.getName());
		return customer;
	}
	
}
