package com.fingeso.backendtusach.models;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "Seguimiento")
public class Seguimiento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ticket_asociado")
    private Ticket ticket_asociado;
    private LocalDateTime fecha;
    private String actividad;

    public Seguimiento(){}
    public Seguimiento(Ticket ticket_asociado, String actividad){
        this.ticket_asociado = ticket_asociado;
        this.actividad = actividad;
        this.fecha = LocalDateTime.now();
    }

    public Ticket getTicket_asociado() {
        return ticket_asociado;
    }
    public void setTicket_asociado(Ticket ticket_asociado) {
        this.ticket_asociado = ticket_asociado;
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
