package com.fingeso.backendtusach.services;

import com.fingeso.backendtusach.models.Usuario;
import com.fingeso.backendtusach.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarios;


    public Usuario buscarCredenciales(String nombre_usuario, String contrasena){
        return usuarios.buscarUsuarioCredenciales(nombre_usuario, contrasena);
    }

    public ArrayList<Usuario> obtenerAnalistas(){
        ArrayList<Usuario> analistas = usuarios.buscarPorRol("analista");

        return analistas;
    }
}
