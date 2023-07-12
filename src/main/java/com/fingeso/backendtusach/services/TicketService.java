package com.fingeso.backendtusach.services;

import java.util.ArrayList;
import java.util.Optional;

import com.fingeso.backendtusach.models.Ticket;
import com.fingeso.backendtusach.repositories.TicketRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;

    public ArrayList<Ticket> obtenerTickets(){
        return (ArrayList<Ticket>) ticketRepository.findAll();
    }

    public Ticket guardarTicket(Ticket ticket){
        return ticketRepository.save(ticket);
    }

    public Optional<Ticket> obtenerPorId(Long id){
        return ticketRepository.findById(id);
    }
    
    public ArrayList<Ticket> obtenerPorActividad(String actividad){
        return ticketRepository.findByActividad(actividad);
    }
    
    public ArrayList<Ticket> obtenerPorCategoria(String categoria){
        return ticketRepository.findByCategoria(categoria);
    }

    public boolean eliminarTicket(Long id){
        try{
            ticketRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
