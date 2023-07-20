package com.fingeso.backendtusach.dtos.usuario;

import com.fingeso.backendtusach.models.Usuario;

public class DTOSesion {
    public String token;
    public Long id;

    public DTOSesion(Usuario usuario){
        token = usuario.getRol();
        id = usuario.getId();
    }
}
