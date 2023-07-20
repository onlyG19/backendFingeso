package com.fingeso.backendtusach.dtos.ticket;

import com.fingeso.backendtusach.models.Ticket;
import com.fingeso.backendtusach.models.Usuario;

public class DTOCrearTicket {
    private String motivo;
    private String categoria;
    private String cuerpo;
    public Long id_usuario;

    // Transforma el DTO a una entidad valida
    public static Ticket aEntidad(DTOCrearTicket dto, Usuario usuario){
        return new Ticket(dto.motivo, dto.cuerpo, dto.categoria, usuario);
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
