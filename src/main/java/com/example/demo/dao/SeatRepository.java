package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Seat;

@Repository
public interface SeatRepository extends JpaRepository <Seat ,Integer> {

	List<Seat> findAllByCoach(String coach);

}
