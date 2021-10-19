package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ScheduleFlightRepository;
import com.example.demo.dao.ScheduleRepository;
import com.example.demo.model.Booking;
import com.example.demo.model.Schedule;
import com.example.demo.model.ScheduleFlight;

@Service
public class ScheduledFlightServiceImpl implements ScheduleFlightService {

	/*
	 * Creating DAO object
	 */
	@Autowired
	private ScheduleFlightRepository repository;

	@Autowired
	ScheduleRepository schedulerepo;

	@Autowired
	BookingService bookingService;

	/*
	 * Service method to add new Scheduled flight to database
	 */
	@Override
	public ScheduleFlight addScheduledFlight(ScheduleFlight scheduledFlight) {
		return repository.save(scheduledFlight);
	}

	/*
	 * Service method to modify existing Scheduled flight in database
	 */
	@Override
	public ScheduleFlight modifyScheduledFlight(ScheduleFlight scheduleFlight) {
		
			// TODO Auto-generated method stub
			ScheduleFlight p = repository.findById(scheduleFlight.getScheduleFlightId())
					.orElseThrow(() -> new EntityNotFoundException("Currently No schedule Available with this id"));
			p.setScheduleTime(scheduleFlight.getScheduleTime());
			return repository.save(p);
		}
	

	/*
	 * Service method to remove existing Scheduled flight from database
	 */
	
	// @Override
	// public boolean cancelBookings(BigInteger flightId) throws
	// RecordNotFoundException {
	// Iterable<Booking> bookingList = bookingService.displayAllBooking();
	// for (Booking booking : bookingList) {
	// if (booking.getScheduleFlight().getScheduleFlightId().equals(flightId)) {
	// bookingService.deleteBooking(booking.getBookingId());
	// }
	// }
	// return true;
	// }

	/*
	 * Service method to view all Scheduled flights in database
	 */
	

	/*
	 * Service method to view a Scheduled flight by ID from database
	 */
	

	

	

	@Override
	public ScheduleFlight viewScheduledFlight(int id) {
		// TODO Auto-generated method stub
		Optional<ScheduleFlight> scheduleFlight = repository.findById(id);
		
		return scheduleFlight.get();
	}

	@Override
	public List<ScheduleFlight> viewAllScheduledFlights() {
		// TODO Auto-generated method stub
		List<ScheduleFlight> b = repository.findAll();
		if (b.isEmpty()) {
			throw new NullPointerException("Currently No schedule Available in the list");
		} else
			return b;
	}

	@Override
	public ScheduleFlight removeScheduledFlight(ScheduleFlight scheduleFlight) {
		// TODO Auto-generated method stub
		repository.findById(scheduleFlight.getScheduleFlightId())
		.orElseThrow(() -> new EntityNotFoundException("Currently No Plant Available with this id"));
         repository.delete(scheduleFlight);
		return null;
	}

}