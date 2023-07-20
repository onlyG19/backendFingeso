package com.fingeso.backendtusach.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fingeso.backendtusach.dtos.usuario.DTOCredencial;
import com.fingeso.backendtusach.dtos.usuario.DTOSesion;
import com.fingeso.backendtusach.dtos.usuario.DTOUsuarioSimple;
import com.fingeso.backendtusach.models.Usuario;
import com.fingeso.backendtusach.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuario_service;

    @PostMapping("/iniciar-sesion")
    public ResponseEntity<DTOSesion> iniciarSesion(@RequestBody DTOCredencial credencial){
        DTOSesion sesion = null;
        HttpStatus estado = HttpStatus.FORBIDDEN;
        
        Usuario usuario = usuario_service.buscarCredenciales(credencial.getNombre_usuario(), credencial.getContrasena());

        if(usuario != null){
            sesion = new DTOSesion(usuario);
            estado = HttpStatus.ACCEPTED;
        }

        return new ResponseEntity<DTOSesion>(
            sesion, 
            new HttpHeaders(), 
            estado
        );
    }

    @GetMapping("/analistas")
    public ArrayList<DTOUsuarioSimple> obtenerAnalistas(){
        ArrayList<Usuario> analistas_raw = usuario_service.obtenerAnalistas();
        
        ArrayList<DTOUsuarioSimple> analistas = new ArrayList<>();
        analistas_raw.forEach(analista -> analistas.add(DTOUsuarioSimple.aDTO(analista)));

        return analistas;
    }
}
