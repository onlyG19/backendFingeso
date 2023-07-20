package com.fingeso.backendtusach.dtos.ticket;
import java.time.LocalDate;
import com.fingeso.backendtusach.models.Ticket;

public class DTOTicketLista {
    public Long id;
    public String motivo;
    public String categoria;
    public String estado;
    public LocalDate fecha_creacion;
    public LocalDate ultima_revision;

    // Transforma una entidad a un DTO
    public static DTOTicketLista aDTO(Ticket ticket){
        DTOTicketLista dto = new DTOTicketLista();

        dto.id = ticket.getId();
        dto.motivo = ticket.getTitulo();
        dto.categoria = ticket.getCategoria();
        dto.fecha_creacion = ticket.getFechaCreacion().toLocalDate();
        dto.estado = ticket.estado;

        return dto;
    }
}
