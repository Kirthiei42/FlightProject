package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Booking;

public interface BookingService {
	

		 Booking createBooking(Booking newBook);

		 Booking updateBooking(Booking newBook);

		 Booking deleteBooking(Booking newBook);

		 List<Booking> displayAllBooking();

		 Booking viewBookingById(int bookingId);
	}


