package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Seat;


public interface SeatService {
	Seat addSeat(Seat seat);
	Seat updateSeat(Seat seat);
	Seat deleteSeat(Seat seat);
	List<Seat> viewAllSeats();
	List<Seat> viewAllSeats(String coach);

}
