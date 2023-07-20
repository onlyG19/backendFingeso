package com.fingeso.backendtusach.models;

import java.time.LocalDateTime;
import javax.persistence.*;


@Entity
@Table(name = "Respuesta")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ticket_asociado")
    private Ticket ticket_asociado;
    private LocalDateTime fecha;
    private String respuesta;
    public boolean aceptada;

    protected Respuesta(){}
    public Respuesta(Ticket ticket_asociado, String respuesta){
        fecha = LocalDateTime.now();
        aceptada = false;

        this.ticket_asociado = ticket_asociado;
        this.respuesta = respuesta;
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

    public String getRespuesta(){
        return respuesta;
    }
}
