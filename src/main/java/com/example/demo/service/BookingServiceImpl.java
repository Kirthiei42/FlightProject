package com.example.demo.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BookingRepository;
import com.example.demo.model.Booking;


@Service
public class BookingServiceImpl implements BookingService {
	@Autowired
	private BookingRepository repository;

	@Override
	public Booking createBooking(Booking newBook) {
		// TODO Auto-generated method stub
		return repository.save(newBook);
	}

	@Override
	public Booking updateBooking(Booking newBook) {
		// TODO Auto-generated method stub
		Booking p = repository.findById(newBook.getBookingId())
				.orElseThrow(() -> new EntityNotFoundException("Currently No Booking Available with this id"));
		p.setPassengerAddress(newBook.getPassengerAddress());
		return repository.save(p);
	}

	@Override
	public Booking deleteBooking(Booking newBook) {
		// TODO Auto-generated method stub
		repository.findById(newBook.getBookingId())
		.orElseThrow(() -> new EntityNotFoundException("Currently No Booking Available with this id"));
         repository.delete(newBook);

		return null;
	}

	@Override
	public List<Booking> displayAllBooking() {
		// TODO Auto-generated method stub
		List<Booking> b = repository.findAll();
		if (b.isEmpty()) {
			throw new NullPointerException("Currently No booking Available in the list");
		} else
			return b;
	}
	

	@Override
	public Booking viewBookingById(int bookingId) {
		// TODO Auto-generated method stub
		Booking b = repository.findById(bookingId)
				.orElseThrow(() -> new EntityNotFoundException("Currently No booking Available with this id"));
		return b;
	}

}
