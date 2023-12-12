package com.capgemini.example.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.example.entity.Booking;
import com.capgemini.example.entity.Flight;
import com.capgemini.example.entity.Passenger;
import com.capgemini.example.entity.User;
import com.capgemini.example.repository.BookingRepository;
import com.capgemini.example.repository.FlightRepository;
import com.capgemini.example.repository.UserRepository;

@Service
public class BookingServiceImplementation implements BookingService {

	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	FlightRepository flightRepository;

	

	public Booking createBooking(Booking booking) {
		

	    User user =	userRepository.findById(booking.getUser().getUserId()).get();
	    
	    double totalCost = 0;
	    List<Passenger> passengers =  booking.getPassengers();
	
	    totalCost =  (passengers.size() * booking.getAmount());
	    
	    booking.setUser(user);
	    booking.setTotalCost(totalCost);
	    Flight flight = flightRepository.findById(booking.getFlight().getFlightId()).get();
	    booking.setFlight(flight);
	    System.out.println(booking);
	    return bookingRepository.save(booking);

	    
	}

}
