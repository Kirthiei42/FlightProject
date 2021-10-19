package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository <Schedule ,Integer> {

}
