package com.fingeso.backendtusach.repositories;

import com.fingeso.backendtusach.models.Seguimiento;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SeguimientoRepository extends JpaRepository<Seguimiento, Long>{
}