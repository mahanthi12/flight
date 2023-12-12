package com.capgemini.example.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.capgemini.example.entity.Flight;
import com.capgemini.example.entity.Passenger;
import com.capgemini.example.entity.User;

public class BookingDto {
	
	 private int bookingId;
	 private long bookingNumber;
	 private LocalDateTime bookingDate;
	 private LocalDateTime travelDate;
	 private double totalCost;
	 private double amount;
	
	 private User user;
	 
	 private List<Passenger> passenger;
	 
	
	 private Flight flight;


	public BookingDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public BookingDto( long bookingNumber, LocalDateTime bookingDate, LocalDateTime travelDate, double totalCost,
			double amount, User user,  Flight flight) {
		super();
		this.bookingNumber = bookingNumber;
		this.bookingDate = bookingDate;
		this.travelDate = travelDate;
		this.totalCost = totalCost;
		this.amount = amount;
		this.user = user;
		//this.passengers = passengers;
		this.flight = flight;
	}



	public int getBookingId() {
		return bookingId;
	}


	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}


	public long getBookingNumber() {
		return bookingNumber;
	}


	public void setBookingNumber(long bookingNumber) {
		this.bookingNumber = bookingNumber;
	}


	


	public LocalDateTime getBookingDate() {
		return bookingDate;
	}



	public void setBookingDate(LocalDateTime bookingDate) {
		this.bookingDate = bookingDate;
	}



	public LocalDateTime getTravelDate() {
		return travelDate;
	}



	public void setTravelDate(LocalDateTime travelDate) {
		this.travelDate = travelDate;
	}



	public double getTotalCost() {
		return totalCost;
	}


	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}
	
//	public List<Passenger> getPassengers() {
//		return passengers;
//	}
//
//
//	public void setPassengers(List<Passenger> passengers) {
//		this.passengers = passengers;
//	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}
}
