package com.fingeso.backendtusach.dtos.usuario;

import com.fingeso.backendtusach.models.Usuario;

public class DTOUsuarioSimple {
    private Long id;
    private String nombre;

    public static DTOUsuarioSimple aDTO(Usuario entidad){
        DTOUsuarioSimple dto = new DTOUsuarioSimple();

        dto.id = entidad.getId();
        dto.nombre = entidad.getNombre_usuario();

        return dto;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
