package com.fingeso.backendtusach.models;

import javax.persistence.*;

@Entity
@Table(name = "Ticket")
public class Ticket {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String clave_externa;
    private Integer estado;
    private String actividad;
    private String categoria;
    private Long id_analista_asignado;
    private String titulo;
    private String cuerpo;
    private String archivo_adjunto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getId_analista_asignado() {
        return id_analista_asignado;
    }

    public void setId_analista_asignado(Long id_analista_asignado) {
        this.id_analista_asignado = id_analista_asignado;
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
}
