package com.example.demo.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.FlightRepository;
import com.example.demo.model.Flight;

@Service
public class FlightServiceImpl implements FlightService {
	@Autowired
	private FlightRepository repository;

	@Override
	public Flight addFlight(Flight flight) {
		// TODO Auto-generated method stub
		return repository.save(flight);
	}

	@Override
	public Flight updateFlight(Flight flight) {
		// TODO Auto-generated method stub
		Flight p = repository.findById(flight.getFlightId())
				.orElseThrow(() -> new EntityNotFoundException("Currently No flight Available with this id"));
		p.setLocations(flight.getLocations());
		return repository.save(p);
	}

	@Override
	public Flight deleteFlight(Flight flight) {
		// TODO Auto-generated method stub
		repository.findById(flight.getFlightId())
		.orElseThrow(() -> new EntityNotFoundException("Currently No Plant Available with this id"));
         repository.delete(flight);

		return null;
	}

	@Override
	public Flight viewFlight(int flightId) {
		// TODO Auto-generated method stub
		Flight f = repository.findById(flightId)
				.orElseThrow(() -> new EntityNotFoundException("Currently No flight Available with this id"));
		return f;
	}

	@Override
	public Flight viewFlight(String locations) {
		// TODO Auto-generated method stub
		Flight f = repository.findByLocations(locations)
				.orElseThrow(() -> new EntityNotFoundException("Currently No flight Available in this location"));
		return f;
	}

	@Override
	public List<Flight> viewAllFlights() {
		// TODO Auto-generated method stub
		List<Flight> f = repository.findAll();
		if (f.isEmpty()) {
			throw new NullPointerException("Currently No flight Available in the list");
		} else
			return f;
	}
	

	@Override
	public List<Flight> viewAllFlights(String locations) {
		// TODO Auto-generated method stub
		List<Flight> p = repository.findAllByLocations(locations);

		if (p.isEmpty()) {
			throw new NullPointerException("Currently No Plant Available in the list");
		} else
			return p;
	}
	}


