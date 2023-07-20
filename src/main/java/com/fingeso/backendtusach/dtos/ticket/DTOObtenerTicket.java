package com.fingeso.backendtusach.dtos.ticket;
import java.util.ArrayList;
import java.util.List;

import com.fingeso.backendtusach.dtos.seguimiento.DTOSeguimiento;
import com.fingeso.backendtusach.models.Ticket;

public class DTOObtenerTicket {
    public String motivo;
    public String categoria;
    public String cuerpo;
    public String estado;
    public String respuesta;
    public List<DTOSeguimiento> seguimiento;

    // Transforma una entidad a un DTO
    public static DTOObtenerTicket aDTO(Ticket ticket){
        DTOObtenerTicket dto = new DTOObtenerTicket();

        dto.motivo = ticket.getTitulo();
        dto.categoria = ticket.getCategoria();
        dto.cuerpo = ticket.getCuerpo();
        dto.estado = ticket.estado;

        // Historial de seguimiento
        ArrayList<DTOSeguimiento> historial = new ArrayList<>();
        ticket.getHistorial().forEach(el -> historial.add(DTOSeguimiento.aDTO(el)));
        // Ordena el historial de mas reciente a mas antiguo
        historial.sort((a, b) -> b.getFecha().compareTo(a.getFecha()));
        dto.seguimiento = historial;

        // Respuesta del ticket
        if(!ticket.getRespuestas().isEmpty()){
            dto.respuesta = ticket.getRespuestas().get(ticket.getRespuestas().size() - 1).getRespuesta();
        }

        return dto;
    }
}
