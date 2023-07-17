package com.fingeso.backendtusach.dtos.seguimiento;
import java.time.LocalDateTime;
import com.fingeso.backendtusach.models.Seguimiento;

public class DTOSeguimiento {
    private LocalDateTime fecha;
    private String actividad;

    // Transforma la entidad a un DTO
    public static DTOSeguimiento aDTO(Seguimiento entidad){
        DTOSeguimiento dto = new DTOSeguimiento();

        dto.fecha = entidad.getFecha();
        dto.actividad = entidad.getActividad();

        return dto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }
}
