package com.capgemini.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.example.entity.Booking;
import com.capgemini.example.service.BookingService;

@RestController
@RequestMapping("/api/v1")
public class BookingController {

	@Autowired
	BookingService bookingService;
	
	@PostMapping("/booking")
	public ResponseEntity<Booking> addbooking(@RequestBody Booking booking){
		System.out.println(booking);
		return new ResponseEntity<Booking>(bookingService.createBooking(booking), HttpStatus.OK);
	}
	
}
