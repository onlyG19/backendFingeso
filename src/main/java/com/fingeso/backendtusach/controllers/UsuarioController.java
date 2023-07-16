package com.fingeso.backendtusach.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fingeso.backendtusach.dtos.usuario.DTOCredencial;
import com.fingeso.backendtusach.dtos.usuario.DTOSesion;
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
        
        String token = usuario_service.validarCredenciales(credencial.getNombre_usuario(), credencial.getContrasena());

        if(token != null){
            sesion = new DTOSesion(token);
            estado = HttpStatus.ACCEPTED;
        }

        return new ResponseEntity<DTOSesion>(
            sesion, 
            new HttpHeaders(), 
            estado
        );
    }
}
