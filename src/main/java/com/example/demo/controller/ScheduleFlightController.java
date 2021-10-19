package com.example.demo.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.model.ScheduleFlight;

import com.example.demo.service.ScheduleFlightService;

@RestController
@RequestMapping("/schedule")
public class ScheduleFlightController {
	@Autowired
	private ScheduleFlightService scheduleFlightService;
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<ScheduleFlight> addFlight(@Valid @RequestBody ScheduleFlight scheduleFlight) {
		ScheduleFlight fl = scheduleFlightService.addScheduledFlight(scheduleFlight);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(fl.getScheduleFlightId())
				.toUri();
		return ResponseEntity.created(location).body(fl);
	}
	
	// UPDATE THE SEAT
	@PutMapping("/update/{id}")
	public ResponseEntity<ScheduleFlight> updateFLIGHT(@RequestBody ScheduleFlight scheduleFlight) {
		ScheduleFlight fl = scheduleFlightService.modifyScheduledFlight(scheduleFlight);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(fl.getScheduleFlightId())
				.toUri();
		return ResponseEntity.created(location).body(fl);
	}
	
	// DELETE SEAT
		@DeleteMapping("/delete/{id}")
		@ResponseStatus(HttpStatus.OK)
		public ResponseEntity<String> deleteScheduleFlight(@RequestBody ScheduleFlight scheduleFlight) {
			ScheduleFlight fl =scheduleFlightService.removeScheduledFlight(scheduleFlight);
			if (fl == null) {
				return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("Problem in deleting", HttpStatus.BAD_REQUEST);
			}
		}
		
		// VIEW ALL SEATS
		@GetMapping("/schedules")
		public List<ScheduleFlight> viewAllScheduleFlight() {
			return scheduleFlightService.viewAllScheduledFlights();
		}
		

}
