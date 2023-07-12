package com.fingeso.backendtusach.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.fingeso.backendtusach.services.TicketService;
import com.fingeso.backendtusach.models.Ticket;
import com.fingeso.backendtusach.dtos.ticket.*;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    TicketService ticketService;

    @GetMapping()
    public ArrayList<DTOTicketLista> obtenerTickets(){
        return new ArrayList<>(ticketService
            .obtenerTickets()
            .stream()
            .map((ticket) -> DTOTicketLista.aDTO(ticket))
            .toList()
        );
    }

    @PostMapping()
    public Ticket guardarTicket(@RequestBody DTOCrearTicket ticket){
        return ticketService.guardarTicket(DTOCrearTicket.aEntidad(ticket));
    }

    @GetMapping(path = "/{id}")
    public Optional<DTOObtenerTicket> obtenerTicketPorId(@PathVariable("id") Long id){
        return ticketService.obtenerPorId(id)
            .map((ticket) -> DTOObtenerTicket.aDTO(ticket));
    }
    
    @GetMapping("/query")
    public ArrayList<Ticket> obtenerTicketPorActividad(@RequestParam("actividad") String actividad){
        return ticketService.obtenerPorActividad(actividad);
    }
    
    @GetMapping("/query1")
    public ArrayList<Ticket> obtenerTicketPorCategoria(@RequestParam("categoria") String categoria){
       return ticketService.obtenerPorCategoria(categoria);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = ticketService.eliminarTicket(id);
        if(ok){
            return "Se eliminó el ticket con id: " + id;
        }else{
            return "No se pudo eliminar el ticket con id: " + id;
        }
    }
}
