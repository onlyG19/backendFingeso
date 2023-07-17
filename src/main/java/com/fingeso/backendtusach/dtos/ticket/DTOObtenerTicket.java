package com.fingeso.backendtusach.dtos.ticket;
import java.util.ArrayList;
import java.util.List;

import com.fingeso.backendtusach.dtos.seguimiento.DTOSeguimiento;
import com.fingeso.backendtusach.models.Ticket;

public class DTOObtenerTicket {
    private String motivo;
    private String categoria;
    private String cuerpo;
    private String respuesta;
    private List<DTOSeguimiento> seguimiento;

    // Transforma una entidad a un DTO
    public static DTOObtenerTicket aDTO(Ticket ticket){
        DTOObtenerTicket dto = new DTOObtenerTicket();

        dto.motivo = ticket.getTitulo();
        dto.categoria = ticket.getCategoria();
        dto.cuerpo = ticket.getCuerpo();

        ArrayList<DTOSeguimiento> historial = new ArrayList<>();
        ticket.getHistorial().forEach(el -> historial.add(DTOSeguimiento.aDTO(el)));
        // Ordena el historial de mas reciente a mas antiguo
        historial.sort((a, b) -> b.getFecha().compareTo(a.getFecha()));
        dto.seguimiento = historial;

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
    public List<DTOSeguimiento> getSeguimiento() {
        return seguimiento;
    }
    public void setSeguimiento(List<DTOSeguimiento> seguimiento) {
        this.seguimiento = seguimiento;
    }

}
