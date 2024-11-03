package com.king.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.king.dao.TicketBookingDao;
import com.king.entities.Ticket;

@Service
public class TicketBookingService {

	@Autowired
	private TicketBookingDao ticketBookingDao;
	
	public Ticket getTicketById(Integer ticketId) {
		
		Optional<Ticket> opTicket = ticketBookingDao.findById(ticketId);
		Ticket ticket = opTicket.get();
		return ticket;
	}
	public Iterable<Ticket> getAllBookedTickets() {
		return ticketBookingDao.findAll();
	}
}