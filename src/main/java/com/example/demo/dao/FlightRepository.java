package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Flight;
@Repository
public interface FlightRepository extends JpaRepository <Flight ,Integer> {

	Optional<Flight> findByLocations(String location);

	List<Flight> findAllByLocations(String location);

}
