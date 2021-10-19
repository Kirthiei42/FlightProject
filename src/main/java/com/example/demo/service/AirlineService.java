package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Airline;


public interface AirlineService {
	Airline createAirline(Airline airline);

	 Airline updateAirline(Airline airline);

	 Airline deleteAirline(Airline airline);

	 List<Airline> veiwAllAirline();

}
