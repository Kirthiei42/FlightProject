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

import com.example.demo.model.Flight;
import com.example.demo.model.Seat;
import com.example.demo.service.SeatService;

@RestController
@RequestMapping("/seat")
public class SeatController {
	@Autowired
	private SeatService seatService; 
	
	// ADD THE SEATS
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Seat> addSeat(@Valid @RequestBody Seat seat) {
		Seat fl = seatService.addSeat(seat);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(fl.getSeatId())
				.toUri();
		return ResponseEntity.created(location).body(fl);
	}
	
	// UPDATE THE SEAT
	@PutMapping("/update/{id}")
	public ResponseEntity<Seat> updateSeat(@RequestBody Seat seat) {
		Seat fl = seatService.updateSeat(seat);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(fl.getSeatId())
				.toUri();
		return ResponseEntity.created(location).body(fl);
	}
	
	// DELETE SEAT
		@DeleteMapping("/delete/{id}")
		@ResponseStatus(HttpStatus.OK)
		public ResponseEntity<String> deleteSeat(@RequestBody Seat seat) {
			Seat fl = seatService.deleteSeat(seat);
			if (fl == null) {
				return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("Problem in deleting", HttpStatus.BAD_REQUEST);
			}
		}
		
		// VIEW ALL SEATS
		@GetMapping("/seats")
		public List<Seat> viewAllSeat() {
			return seatService.viewAllSeats();
		}
		
		// VIEW FLIGHT BY TYPE
		@GetMapping("/seat/coach")
		public List<Seat> viewAllSeats(String coach) {
			return seatService.viewAllSeats(coach);
		}

}
