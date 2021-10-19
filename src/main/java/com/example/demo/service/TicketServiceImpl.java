package com.example.demo.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.example.demo.dao.TicketRepository;
import com.example.demo.model.Airline;
import com.example.demo.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
@Service
public class TicketServiceImpl implements TicketService {
	@Autowired
	private TicketRepository repository;

	@Override
	public Ticket addTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		return repository.save(ticket);
	}

	@Override
	public Ticket updateTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		Ticket p = repository.findById(ticket.getTicketId())
				.orElseThrow(() -> new EntityNotFoundException("Currently No ticket Available with this id"));
		p.setAmount(ticket.getAmount());
		return repository.save(p);
	}

	@Override
	public Ticket deleteTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		repository.findById(ticket.getTicketId())
		.orElseThrow(() -> new EntityNotFoundException("Currently No ticket Available with this id"));
         repository.delete(ticket);
		return null;
	}

	@Override
	public List<Ticket> veiwAllTicket() {
		// TODO Auto-generated method stub
		List<Ticket> f = repository.findAll();
		if (f.isEmpty()) {
			throw new NullPointerException("Currently No ticket Available in the list");
		} else
			return f;
	}
	}


