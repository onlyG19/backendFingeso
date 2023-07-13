package com.fingeso.backendtusach.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fingeso.backendtusach.dtos.usuario.DTOCredencial;
import com.fingeso.backendtusach.dtos.usuario.DTOSesion;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @PostMapping("/iniciar-sesion")
    public ResponseEntity<DTOSesion> iniciarSesion(@RequestBody DTOCredencial credencial){
        DTOSesion sesion = null;
        HttpStatus estado = HttpStatus.FORBIDDEN;
        
        if(credencial.getNombre_usuario().equals("adminusuario") && credencial.getContrasena().equals("admin")){
            sesion = new DTOSesion("stringrandomcontokenyesascosas");
            estado = HttpStatus.ACCEPTED;
        }

        return new ResponseEntity<DTOSesion>(
            sesion, 
            new HttpHeaders(), 
            estado
        );
    }
}
