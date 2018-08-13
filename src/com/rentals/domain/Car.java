package com.rentals.domain;

import com.wf.domain.Rental;
import com.wf.domain.annotation.Reservable;

@Reservable
public class Car extends Rental {
	private String model;
	private int year;
	
	public Car() {
		super();
	}

	public Car(String model, int year) {
		super();
		this.model = model;
		this.year = year;
	}
	
	public Car(String model, int year, Double priceRate, Double rentalTimeslot ) {
		super();
		this.model = model;
		this.year = year;
		this.setPriceRate(priceRate);
		this.setRentalTimeslot(rentalTimeslot);
	}
	
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public Car clone() {
		Car car = new Car();
		car.setModel(this.getModel());
		car.setPriceRate(this.getPriceRate());
		car.setYear(this.getYear());
		car.setRentalTimeslot(this.getRentalTimeslot());
		return car;
	}
	
}
