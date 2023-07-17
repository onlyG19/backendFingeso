package com.fingeso.backendtusach.services;

import com.fingeso.backendtusach.models.Usuario;
import com.fingeso.backendtusach.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarios;


    public String validarCredenciales(String nombre_usuario, String contrasena){
        Usuario usuario = usuarios.buscarUsuarioCredenciales(nombre_usuario, contrasena);

        if(usuario == null){
            return null;
        }

        return usuario.getRol();
    }
}
