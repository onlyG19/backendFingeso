package com.fingeso.backendtusach.dtos.ticket;
import java.time.LocalDate;
import com.fingeso.backendtusach.models.Ticket;

public class DTOTicketLista {
    private Long id;
    private String motivo;
    private String categoria;
    private LocalDate fecha_creacion;
    private LocalDate ultima_revision;

    // Transforma una entidad a un DTO
    public static DTOTicketLista aDTO(Ticket ticket){
        DTOTicketLista dto = new DTOTicketLista();

        dto.id = ticket.getId();
        dto.motivo = ticket.getTitulo();
        dto.categoria = ticket.getCategoria();
        dto.fecha_creacion = ticket.getFechaCreacion().toLocalDate();
        
        return dto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getMotivo() {
        return motivo;
    }
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public LocalDate getFecha_creacion() {
        return fecha_creacion;
    }
    public void setFecha_creacion(LocalDate fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }
    public LocalDate getUltima_revision() {
        return ultima_revision;
    }
    public void setUltima_revision(LocalDate ultima_revision) {
        this.ultima_revision = ultima_revision;
    }
}
