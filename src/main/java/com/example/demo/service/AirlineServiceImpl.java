package com.example.demo.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AirlineRepository;

import com.example.demo.model.Airline;

@Service
public class AirlineServiceImpl implements AirlineService {
	@Autowired
	private AirlineRepository repository;

	@Override
	public Airline createAirline(Airline airline) {
		// TODO Auto-generated method stub
		return repository.save(airline);
	}

	@Override
	public Airline updateAirline(Airline airline) {
		// TODO Auto-generated method stub
		Airline p = repository.findById(airline.getAirlineId())
				.orElseThrow(() -> new EntityNotFoundException("Currently No airline Available with this id"));
		p.setContactNumber(airline.getContactNumber());
		return repository.save(p);
	}

	@Override
	public Airline deleteAirline(Airline airline) {
		// TODO Auto-generated method stub
		repository.findById(airline.getAirlineId())
		.orElseThrow(() -> new EntityNotFoundException("Currently No Airline Available with this id"));
         repository.delete(airline);
		return null;
	}

	@Override
	public List<Airline> veiwAllAirline() {
		// TODO Auto-generated method stub
		List<Airline> f = repository.findAll();
		if (f.isEmpty()) {
			throw new NullPointerException("Currently No flight Available in the list");
		} else
			return f;
	}
	}


