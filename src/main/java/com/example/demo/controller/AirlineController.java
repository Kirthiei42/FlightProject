package com.example.demo.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.model.Airline;
import com.example.demo.service.AirlineService;

@RestController
@RequestMapping("/airline")
public class AirlineController {
	@Autowired
	private AirlineService airlineService;
	// ADD AIRLINE
		@PostMapping("/add")
		@ResponseStatus(HttpStatus.CREATED)
		public ResponseEntity<Airline> addAirline(@Valid @RequestBody Airline airline) {
			Airline fl = airlineService.createAirline(airline);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(fl.getAirlineId())
					.toUri();
			return ResponseEntity.created(location).body(fl);
		}

		// UPDATE AIRLNE
		@PutMapping("/update/{id}")
		public ResponseEntity<Airline> updateAirline(@RequestBody Airline airline) {
			Airline fl = airlineService.updateAirline(airline);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(fl.getAirlineId())
					.toUri();
			return ResponseEntity.created(location).body(fl);
		}

		// DELETE AIRLINE
		@DeleteMapping("/delete/{id}")
		@ResponseStatus(HttpStatus.OK)
		public ResponseEntity<String> deleteAirline(@RequestBody Airline airline) {
			Airline fl = airlineService.deleteAirline(airline);
			if (fl == null) {
				return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("Problem in deleting", HttpStatus.BAD_REQUEST);
			}
		}

		// VIEW ALL AIRLINES
		@GetMapping("/airlines")
		public List<Airline> viewAllAirlines() {
			return airlineService.veiwAllAirline();
		}
}
