package com.fingeso.backendtusach.repositories;

import java.util.ArrayList;

import com.fingeso.backendtusach.models.Ticket;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Long> {
    
    public abstract ArrayList<Ticket> findByActividad(String actividad);
    public abstract ArrayList<Ticket> findByCategoria(String categoria);
}
