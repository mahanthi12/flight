package com.capgemini.example.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;



@Entity
@Table(name="Booking")
public class Booking {
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name="booking_id")
	 private int bookingId;
	 private long bookingNumber;
	 private LocalDateTime bookingDate;
	 private LocalDateTime travelDate;
	 private double totalCost;
	 private double amount;
	 @ManyToOne
	 @JoinColumn(name="userid")
	 @JsonBackReference(value="user_id")
	 private User user;
	 
	 @OneToMany(mappedBy="booking",cascade=CascadeType.ALL)
	 @JsonManagedReference(value="booking_id")
	 private List<Passenger> passengers;
	 
	 @OneToOne
	 @JoinColumn(name="flight_id")
	 private Flight flight;

	public Booking() {
		super();
	}

	public Booking( long bookingNumber, LocalDateTime bookingDate, LocalDateTime travelDate, double totalCost,
			double amount, User user, List<Passenger> passengers, Flight flight) {
		super();
		
		this.bookingNumber = bookingNumber;
		this.bookingDate = bookingDate;
		this.travelDate = travelDate;
		this.totalCost = totalCost;
		this.amount = amount;
		this.user = user;
		this.passengers = passengers;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", bookingNumber=" + bookingNumber + ", bookingDate=" + bookingDate
				+ ", travelDate=" + travelDate + ", totalCost=" + totalCost + ", amount=" + amount + ", user=" + user.getUserId()
				+ ", passengers=" + passengers + ", flight=" + flight.getFlightId() + "]";
	}
	 
	 

}
