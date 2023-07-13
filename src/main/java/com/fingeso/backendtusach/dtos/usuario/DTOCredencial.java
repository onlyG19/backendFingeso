package com.fingeso.backendtusach.dtos.usuario;

public class DTOCredencial{
    private String nombre_usuario;
    private String contrasena;

    
    public String getNombre_usuario() {
        return nombre_usuario;
    }
    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
