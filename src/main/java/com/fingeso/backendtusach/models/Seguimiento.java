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

    protected Seguimiento(){}
    public Seguimiento(Ticket ticket_asociado, String actividad){
        fecha = LocalDateTime.now();

        this.ticket_asociado = ticket_asociado;
        this.actividad = actividad;
    }

    public Long getId(){
        return id;
    }

    public Ticket getTicket(){
        return ticket_asociado;
    }

    public LocalDateTime getFecha(){
        return fecha;
    }

    public String getActividad(){
        return actividad;
    }
}
