package com.fingeso.backendtusach.repositories;

import java.util.ArrayList;

import com.fingeso.backendtusach.models.Ticket;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Long> {
    @Query("SELECT tk FROM Ticket tk WHERE tk.usuario_asociado.id = ?1")
    public ArrayList<Ticket> buscarPorUsuarioAsociado(Long id_usuario);

    public abstract ArrayList<Ticket> findByActividad(String actividad);
    public abstract ArrayList<Ticket> findByCategoria(String categoria);
}
