package com.fingeso.backendtusach.dtos.usuario;

public class DTOSesion {
    private String token = null;

    public DTOSesion(String token){
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
