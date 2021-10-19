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

import com.example.demo.model.Booking;
import com.example.demo.model.Flight;
import com.example.demo.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {
	@Autowired
	private BookingService bookingService;
	
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Booking> createBooking(@Valid @RequestBody Booking newBook) {
		Booking b = bookingService.createBooking(newBook);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(b.getBookingId())
				.toUri();
		return ResponseEntity.created(location).body(b);
	}

	// UPDATE ADDRESS BY ID 
	@PutMapping("/update/{id}")
	public ResponseEntity<Booking> updateBooking(@RequestBody Booking newBook) {
		Booking b = bookingService.updateBooking(newBook);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(b.getBookingId())
				.toUri();
		return ResponseEntity.created(location).body(b);
	}

	// CANCELING THE BOOKING
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deleteBooking(@RequestBody Booking newBook) {
		Booking b = bookingService.deleteBooking(newBook);
		if (b == null) {
			return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Problem in deleting", HttpStatus.BAD_REQUEST);
		}
	}

	// VIEW ALL BOOKINGS
	@GetMapping("/booking")
	public List<Booking> viewAllBookings() {
		return bookingService.displayAllBooking();
	}

	// VIEW FLIGHT BY ID
	@GetMapping("/find/{bookingid}")
	public ResponseEntity<Booking> viewBookingById(@PathVariable("bookingid") int BookingId) {
		Booking b = bookingService.viewBookingById(BookingId);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(b.getBookingId())
				.toUri();
		return ResponseEntity.created(location).body(b);
	}

}
