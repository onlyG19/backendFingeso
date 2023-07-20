package com.fingeso.backendtusach.repositories;

import com.fingeso.backendtusach.models.Respuesta;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RespuestaRepository extends JpaRepository<Respuesta, Long>{
}