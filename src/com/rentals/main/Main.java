package com.rentals.main;

import java.util.List;
import java.util.Scanner;

import com.rentals.domain.Car;
import com.rentals.domain.Customer;
import com.rentals.repository.CarRepository;
import com.rentals.repository.CustomerRepository;
import com.wf.domain.Reservation;
import com.wf.domain.builder.ReservationBuilder;
import com.wf.domain.builder.ReservationBuilderDirector;
import com.wf.domain.repository.ReservationRepository;


public class Main {

	public static void main(String[] args) {
		CustomerRepository cr = new CustomerRepository();
		Customer customer = new Customer("101", "Customer", "101");
		cr.save(customer);
		/*
		System.out.println(br.findAll().size());
		
		for(Block b : br.findAll()) {
			System.out.println(b.getName());
		}
		 */
		
		Customer sc = cr.find("number", "101");
		
		CarRepository carr = new CarRepository();
		carr.save(new Car("BMW", 2002, 100.0, 1.0));
		carr.save(new Car("Alfa Romeo", 2003, 60.0, 1.0));
		carr.save(new Car("Buick", 2010, 90.0, 1.0));
		carr.save(new Car("Chevy", 2004, 50.0, 1.0));
		
		List<Car> cars = carr.findAll();
		List<Customer> customers = cr.findAll();
		
		int action = 1;
		
		
		ReservationBuilderDirector rbd = new ReservationBuilderDirector(new ReservationBuilder());
		ReservationRepository rr = new ReservationRepository();
		
		Car reservationCar = new Car();
		Customer reservationCustomer = new Customer();
		Reservation reservation = new Reservation();
		
		while(action != 0) {
			System.out.println("Options:\n");
			System.out.println("1 - Select a car");
			System.out.println("2 - Select a Customer");
			System.out.println("3 - Finish Reservation");
			System.out.println("4 - New Reservation");
			System.out.println("0 - Exit");
			System.out.print(":");
			Scanner scanner = new Scanner(System. in);
			action = Integer.parseInt(scanner.nextLine());
			if(action == 1) {
				System.out.println("Select one of the following cars:");
				for(Car c : cars) {
					System.out.println(c.getModel());
				}
				reservationCar = carr.find("model", scanner.nextLine());
			} else if(action == 2) {
				System.out.println("Select one of the following customers:");
				for(Customer c : customers) {
					System.out.println(c.getCode() + " - " + c.getName());
				}
				reservationCustomer = cr.find("code", scanner.nextLine());
			} else if(action == 3) {
				rbd.constructReservation(reservationCar, reservationCustomer, null);
				reservation = rbd.getReservation();
				rr.save(reservation);
				System.out.println("Reservation saved:");
				System.out.println(reservationCar.getModel() + " - " + reservationCustomer.getCode());
			} else if(action == 4) {
				reservation = new Reservation();
			} else if(action == 0) {
				System.out.println("Thanks for using the Car Rental Store.");
			} else {
				System.out.println("This option does not exist");
			}
		}
		
	}
}
