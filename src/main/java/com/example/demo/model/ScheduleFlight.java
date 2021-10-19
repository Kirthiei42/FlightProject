package com.example.demo.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;


import lombok.Data;

@Entity
@Data
public class ScheduleFlight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "schedule_flight_id")
	private int scheduleFlightId;

	@OneToOne(fetch = FetchType.EAGER)
	@NotNull
	private Flight flight;

//	@Column(name = "available_seats")
//	@NotNull
    private int scheduleTime;

	@NotNull
	@OneToOne(cascade = CascadeType.ALL)
	private Schedule schedule;
	
	@OneToOne
	private Seat seat;
}