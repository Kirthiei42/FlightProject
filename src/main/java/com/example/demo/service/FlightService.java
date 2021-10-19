package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Flight;



public interface FlightService {
	Flight addFlight(Flight flight);
	Flight updateFlight(Flight flight);
	Flight deleteFlight(Flight flight);
	Flight viewFlight(int flightId);
	Flight viewFlight(String locations);
	List<Flight> viewAllFlights();
	List<Flight> viewAllFlights(String locations);

}
