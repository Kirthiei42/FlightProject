package com.example.demo.model;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;


import lombok.Data;

@Entity
@Data
public class Booking {
	@Id
	// @GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;
	private String bookingDate;
	private String fromdate ;
	private String todate;
	
	
	private String passengerAddress;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Enumerated(EnumType.STRING)
	private MealType MealType;
	
	private String DiscountCode;
	private int SeatNoOnward;
	private int SeatNoReturn;
	
	
	@OneToOne
	private Ticket ticket;
}
