package com.fingeso.backendtusach.models;

import java.time.LocalDate;
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
    private Usuario analista_asociado;

    private String clave_externa;
    private Integer estado;
    private String actividad;
    private String categoria;
    private String titulo;
    private String cuerpo;
    private String archivo_adjunto;
    private LocalDate fecha_creacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario_asociado() {
        return usuario_asociado;
    }

    public void setUsuario_asociado(Usuario usuario_asociado) {
        this.usuario_asociado = usuario_asociado;
    }

    public String getClave_externa() {
        return clave_externa;
    }

    public void setClave_externa(String clave_externa) {
        this.clave_externa = clave_externa;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Usuario getAnalista_asociado() {
        return analista_asociado;
    }

    public void setAnalista_asociado(Usuario analista_asociado) {
        this.analista_asociado = analista_asociado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public String getArchivo_adjunto() {
        return archivo_adjunto;
    }

    public void setArchivo_adjunto(String archivo_adjunto) {
        this.archivo_adjunto = archivo_adjunto;
    }

    public LocalDate getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(LocalDate fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public List<Seguimiento> getHistorial() {
        return historial;
    }
}
