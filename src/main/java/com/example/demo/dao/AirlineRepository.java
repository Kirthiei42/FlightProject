package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Airline;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, Integer> {

}
