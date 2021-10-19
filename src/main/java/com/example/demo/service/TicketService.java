package com.example.demo.service;

import java.util.List;


import com.example.demo.model.Ticket;

public interface TicketService {
	Ticket addTicket(Ticket ticket);
	Ticket updateTicket(Ticket ticket);
	Ticket deleteTicket(Ticket ticket);

	 List<Ticket> veiwAllTicket();

}
