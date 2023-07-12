package com.fingeso.backendtusach.dtos.ticket;
import com.fingeso.backendtusach.models.Ticket;

public class DTOCrearTicket {
    private String motivo;
    private String categoria;
    private String cuerpo;

    // Transforma el DTO a una entidad valida
    public static Ticket aEntidad(DTOCrearTicket dto){
        Ticket ticket = new Ticket();

        ticket.setTitulo(dto.motivo);
        ticket.setCategoria(dto.categoria);
        ticket.setCuerpo(dto.cuerpo);

        return ticket;
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
    public String getCuerpo() {
        return cuerpo;
    }
    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }
}
