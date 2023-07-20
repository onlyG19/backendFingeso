package com.fingeso.backendtusach.services;

import java.util.ArrayList;
import java.util.Optional;

import com.fingeso.backendtusach.dtos.ticket.DTOCrearTicket;
import com.fingeso.backendtusach.models.Respuesta;
import com.fingeso.backendtusach.models.Seguimiento;
import com.fingeso.backendtusach.models.Ticket;
import com.fingeso.backendtusach.models.Usuario;
import com.fingeso.backendtusach.repositories.RespuestaRepository;
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
    @Autowired
    RespuestaRepository respuestas;

    public ArrayList<Ticket> obtenerTickets(){
        return (ArrayList<Ticket>) ticketRepository.findAll();
    }

    public Ticket guardarTicket(DTOCrearTicket ticket_crear){
        Usuario usuario_asociado = usuarios.findById(ticket_crear.id_usuario).get();

        Ticket ticket = DTOCrearTicket.aEntidad(ticket_crear, usuario_asociado);
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
    
    public ArrayList<Ticket> obtenerPorUsuario(Long id_usuario){
        return ticketRepository.buscarPorUsuarioAsociado(id_usuario);
    }
    
    public ArrayList<Ticket> obtenerPorAsignar(){
        return ticketRepository.buscarPorEstado("Creado");
    }
    
    public ArrayList<Ticket> obtenerPorValidar(){
        return ticketRepository.buscarPorEstado("En Proceso Cierre");
    }
    
    public ArrayList<Ticket> obtenerPorAnalizar(Long id_analista){
        return ticketRepository.buscarPorAnalizar(id_analista);
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

    public void agregarRespuesta(Long id_ticket, String respuesta){
        Ticket ticket = ticketRepository.findById(id_ticket).get();

        agregarActividad(id_ticket, "Enviado a revisión");
        Respuesta nueva_respuesta = new Respuesta(ticket, respuesta);
        respuestas.save(nueva_respuesta);
        ticket.estado = "En Proceso Cierre";
        ticketRepository.save(ticket);
    }

    public void aceptarRespuesta(Long id_ticket){
        Ticket ticket = ticketRepository.findById(id_ticket).get();

        Respuesta respuesta = ticket.getRespuestas().get(ticket.getRespuestas().size() - 1);
        respuesta.aceptada = true;
        respuestas.save(respuesta);

        agregarActividad(id_ticket, "Respuesta aceptada");
        ticket.estado = "Cerrado";
        ticketRepository.save(ticket);
    }
}
