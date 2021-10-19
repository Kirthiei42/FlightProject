package com.example.demo.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.model.Flight;
import com.example.demo.service.FlightService;


@RestController
@RequestMapping("/flight")
public class FlightController {
	@Autowired
	private FlightService flightService;

	// ADD FLIGHT
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Flight> addFlight(@Valid @RequestBody Flight flight) {
		Flight fl = flightService.addFlight(flight);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(fl.getFlightId())
				.toUri();
		return ResponseEntity.created(location).body(fl);
	}

	// UPDATE FLIGHT
	@PutMapping("/update/{id}")
	public ResponseEntity<Flight> updateFlight(@RequestBody Flight flight) {
		Flight fl = flightService.updateFlight(flight);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(fl.getFlightId())
				.toUri();
		return ResponseEntity.created(location).body(fl);
	}

	// DELETE FLIGHT
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deleteFlight(@RequestBody Flight flight) {
		Flight fl = flightService.deleteFlight(flight);
		if (fl == null) {
			return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Problem in deleting", HttpStatus.BAD_REQUEST);
		}
	}

	// VIEW ALL FLIGHTS
	@GetMapping("/flights")
	public List<Flight> viewAllFlights() {
		return flightService.viewAllFlights();
	}

	// VIEW FLIGHT BY ID
	@GetMapping("/find/{flightid}")
	public ResponseEntity<Flight> viewFlight(@PathVariable("flightid") int flightId) {
		Flight fl = flightService.viewFlight(flightId);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(fl.getFlightId())
				.toUri();
		return ResponseEntity.created(location).body(fl);
	}

	// VIEW FLIGHT BY NAME
	@GetMapping("/find/Name/{flighttName}")
	public ResponseEntity<Flight> viewFlight(@PathVariable("flighttName") String locations) {
		Flight fl = flightService.viewFlight(locations);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(fl.getFlightId())
				.toUri();
		return ResponseEntity.created(location).body(fl);
	}

	// VIEW FLIGHT BY TYPE
	@GetMapping("/flight/locations")
	public List<Flight> viewAllFlights(String locations) {
		return flightService.viewAllFlights(locations);
	}

}
