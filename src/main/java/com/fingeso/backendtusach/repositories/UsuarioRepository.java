package com.fingeso.backendtusach.repositories;

import com.fingeso.backendtusach.models.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    @Query("SELECT u FROM Usuario u WHERE u.nombre_usuario = ?1 AND u.contrasena = ?2")
    public Usuario buscarUsuarioCredenciales(String nombre_usuario, String contrasena);

    @Query("SELECT u FROM Usuario u WHERE u.rol = ?1")
    public ArrayList<Usuario> buscarPorRol(String rol);
}
