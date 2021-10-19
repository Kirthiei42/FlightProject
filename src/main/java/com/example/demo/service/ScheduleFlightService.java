package com.example.demo.service;



import java.util.List;

import com.example.demo.model.ScheduleFlight;


public interface ScheduleFlightService {
	 ScheduleFlight addScheduledFlight(ScheduleFlight scheduledFlight);

	 ScheduleFlight modifyScheduledFlight(ScheduleFlight scheduledFlight);

	 ScheduleFlight removeScheduledFlight(ScheduleFlight scheduleFlight);

	 List<ScheduleFlight> viewAllScheduledFlights();

	 ScheduleFlight viewScheduledFlight(int id);
	

	

}
