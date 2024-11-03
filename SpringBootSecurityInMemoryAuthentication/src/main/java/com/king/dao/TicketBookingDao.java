package com.king.dao;

import org.springframework.data.repository.CrudRepository;

import com.king.entities.Ticket;

public interface TicketBookingDao extends CrudRepository<Ticket, Integer>{

}
