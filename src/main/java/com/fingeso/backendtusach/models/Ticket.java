package com.fingeso.backendtusach.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;


@Entity
@Table(name = "Ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    // Usuario que creo el ticket
    @ManyToOne
    @JoinColumn(name = "usuario_asociado")
    private Usuario usuario_asociado;

    // Historial del ticket
    @OneToMany(mappedBy = "ticket_asociado")
    private List<Seguimiento> historial = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "analista_asociado")
    public Usuario analista_asociado;

    private LocalDateTime fecha_creacion;
    private String categoria;
    private String titulo;
    private String cuerpo;

    // Detalles sobre el estado actual del ticket
    public String estado;
    public String actividad;

    protected Ticket() {}
    public Ticket(String titulo, String cuerpo, String categoria){
        fecha_creacion = LocalDateTime.now();
        usuario_asociado = null;
        estado = "Creado";

        this.titulo = titulo;
        this.cuerpo = cuerpo;
        this.categoria = categoria;
    }

    public Long getId(){
        return id;
    }

    public Usuario getUsuarioAsociado(){
        return usuario_asociado;
    }

    public LocalDateTime getFechaCreacion(){
        return fecha_creacion;
    }

    public String getCategoria(){
        return categoria;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getCuerpo(){
        return cuerpo;
    }

    public List<Seguimiento> getHistorial(){
        return historial;
    }
}
