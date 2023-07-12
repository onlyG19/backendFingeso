package com.fingeso.backendtusach.dtos.ticket;
import java.util.List;
import com.fingeso.backendtusach.models.Ticket;

public class DTOObtenerTicket {
    private String motivo;
    private String categoria;
    private String cuerpo;
    private String respuesta;
    private List<Object> seguimiento;

    // Transforma una entidad a un DTO
    public static DTOObtenerTicket aDTO(Ticket ticket){
        DTOObtenerTicket dto = new DTOObtenerTicket();

        dto.motivo = ticket.getTitulo();
        dto.categoria = ticket.getCategoria();
        dto.cuerpo = ticket.getCuerpo();
        
        return dto;
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
    public String getRespuesta() {
        return respuesta;
    }
    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
    public List<Object> getSeguimiento() {
        return seguimiento;
    }
    public void setSeguimiento(List<Object> seguimiento) {
        this.seguimiento = seguimiento;
    }

}
