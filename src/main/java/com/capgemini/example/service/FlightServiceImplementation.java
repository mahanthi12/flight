package com.capgemini.example.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.example.dto.FlightDto;
import com.capgemini.example.entity.Flight;
import com.capgemini.example.entity.Location;
import com.capgemini.example.entity.User;
import com.capgemini.example.exception.FlightNotFoundException;
import com.capgemini.example.exception.IdNotFoundException;
import com.capgemini.example.repository.FlightRepository;
import com.capgemini.example.repository.LocationRepository;

@Service
public class FlightServiceImplementation implements FlightService {
	
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	LocationRepository locationRepository;
	
	public Flight addFlights(Flight flights) {
		
		if(locationRepository.existsById(flights.getLocations().getLocationId()))
		{
			Location location = locationRepository.findById(flights.getLocations().getLocationId()).get();
			flights.setLocations(location);
		}
		return flightRepository.save(flights);
	}
	

	
	
//	@Override
//	public Flight addFlight2(FlightDto flightDto) {
//		
//		Location location= locationRepository.findById(flightDto.getLocationId()).get();
//		
//		Flight flight = new Flight();
//		flight.setLocations(location);
//		flight.setArrivalLocation(flightDto.getArrivalLocation());
//		flight.setDepartureLocation(flightDto.getDepartureLocation());
//		flight.setArrivalTime(flightDto.getArrivalTime());
//		flight.setDepartureTime(flightDto.getDepartureTime());
//		flight.setCode(flightDto.getCode());
//		flight.setFare(flightDto.getFare());
//		flight.setTotalSeats(flightDto.getTotalSeats());
//		flight.setRemainingSeats(flightDto.getRemainingSeats());
//		flight.setModel(flightDto.getModel());
//		
//		return flightRepository.save(flight);
//	}

	public List<Flight> getFlights()throws FlightNotFoundException{
		return flightRepository.findAll();
	}
	
	
	public Flight updateFlight(int flightId,Flight flight) throws IdNotFoundException, FlightNotFoundException {
		Flight updateFlight=null;
		
		if(flightRepository.existsById(flightId))
		{
			updateFlight=flightRepository.findById(flightId).get();
			
			
			flight.setFlightId(flightId);
		
			return flightRepository.save(flight);
		}
		else
		{
			throw new IdNotFoundException("no id found to update");
		}
	
	}

	public String deleteFlightById(int flightId)throws IdNotFoundException, FlightNotFoundException {
		String msg;
		if(flightRepository.existsById(flightId))
		{
			flightRepository.deleteById(flightId);
			msg="flight deleted successfully";
		}
		else {
			throw new IdNotFoundException("USER_ID_NOT_FOUND_INFO");
		}
		return msg;
	}

	public List<Flight> getFlightsByLocationId(int locationId)throws IdNotFoundException{
		List<Flight> flight= flightRepository.getAllFlightsByLocationId(locationId);
		if(flight.size()== 0) {
			 throw new IdNotFoundException("Flight is not available for given location");
		 }
		 return flight;
	}

	public List<Flight> findFlightsByLocations(String departureLocation, String arrivalLocation) throws FlightNotFoundException{
		List<Flight> flight= flightRepository.findFlightsByDepartureLocationAndArrivalLocation(departureLocation, arrivalLocation);
		if(flight.size()== 0) {
			 throw new FlightNotFoundException("Flight is not available for given locations");
		 }
		 return flight;
	}
	public List<Flight> findFlightsByLocationsAndDate(String departureLocation,String arrivalLocation,LocalDateTime departureTime) throws FlightNotFoundException{
		List<Flight> flight= flightRepository.findFlightsByLocationsAndDate(departureLocation, arrivalLocation, departureTime);
		if(flight.size()== 0) {
			 throw new FlightNotFoundException("Flight is not available for given location");
		 }
		 return flight;
		}
	
	 public List<Flight> findByFareLessThanEqual(Double fare)throws FlightNotFoundException{
		 List<Flight> flight= flightRepository.findFlightsByFare(fare);
		 if(flight.size()== 0) {
			 throw new FlightNotFoundException("Flight is not available for given fare");
		 }
		 return flight;
	 }
	 public List<Flight> findFlightsByDate(LocalDateTime departureTime) throws FlightNotFoundException{
		 List<Flight> flight = flightRepository.findFlightsByDate(departureTime);
		 if(flight.size()== 0) {
			 throw new FlightNotFoundException("Flight is not available at given time");
		 }
		 return flight;
	 }
	 public Flight findFlightsByFlightId(int flightId)throws IdNotFoundException{
		 Flight flight=flightRepository.findFlightsByFlightId(flightId);
		 if(flight== null) {
			 throw new IdNotFoundException("Flight id is not present in the db");
		 }
		 return flight;
	 }
}
