package com.example.demo.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.SeatRepository;

import com.example.demo.model.Seat;
@Service
public class SeatServiceImpl  implements SeatService{
	@Autowired
	private SeatRepository repository;
	@Override
	public Seat addSeat(Seat seat) {
		// TODO Auto-generated method stub
		return repository.save(seat);
	}

	@Override
	public Seat updateSeat(Seat seat) {
		// TODO Auto-generated method stub
		Seat s = repository.findById(seat.getSeatId())
				.orElseThrow(() -> new EntityNotFoundException("Currently No seat Available with this id"));
		s.setAvailableSeats(seat.getAvailableSeats());
		return repository.save(s);
	}

	@Override
	public Seat deleteSeat(Seat seat) {
		// TODO Auto-generated method stub
		repository.findById(seat.getSeatId())
		.orElseThrow(() -> new EntityNotFoundException("Currently No seat Available with this id"));
         repository.delete(seat);

		return null;
	}

	@Override
	public List<Seat> viewAllSeats() {
		// TODO Auto-generated method stub
		List<Seat> b = repository.findAll();
		if (b.isEmpty()) {
			throw new NullPointerException("Currently No Seat Available in the list");
		} else
			return b;
	}
	

	@Override
	public List<Seat> viewAllSeats(String coach) {
		// TODO Auto-generated method stub
		List<Seat> p = repository.findAllByCoach(coach);

		if (p.isEmpty()) {
			throw new NullPointerException("Currently No seat Available in the list");
		} else
			return p;
	}

}
