package com.fingeso.backendtusach.services;

import java.util.ArrayList;
import java.util.Optional;

import com.fingeso.backendtusach.models.Seguimiento;
import com.fingeso.backendtusach.models.Ticket;
import com.fingeso.backendtusach.models.Usuario;
import com.fingeso.backendtusach.repositories.SeguimientoRepository;
import com.fingeso.backendtusach.repositories.TicketRepository;
import com.fingeso.backendtusach.repositories.UsuarioRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class TicketService {
    @Autowired
    UsuarioRepository usuarios;
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    SeguimientoRepository seguimientoRepository;

    public ArrayList<Ticket> obtenerTickets(){
        return (ArrayList<Ticket>) ticketRepository.findAll();
    }

    public Ticket guardarTicket(Ticket ticket){
        ticket = ticketRepository.save(ticket);
        agregarActividad(ticket.getId(), "Creado");
        return ticket;
    }

    public Ticket asignarTicket(Long id_ticket, Long id_usuario){
        Ticket ticket = ticketRepository.findById(id_ticket).get();
        Usuario analista = usuarios.findById(id_usuario).get();
        
        ticket.analista_asociado = analista;
        agregarActividad(ticket.getId(), "Asignado");
        ticket.estado = "En Proceso";
        ticketRepository.save(ticket);

        return ticket;
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

    public void agregarActividad(Long id_ticket, String actividad){
        Ticket ticket = ticketRepository.findById(id_ticket).get();

        Seguimiento nueva_actividad = new Seguimiento(ticket, actividad);
        seguimientoRepository.save(nueva_actividad);
    }
}
