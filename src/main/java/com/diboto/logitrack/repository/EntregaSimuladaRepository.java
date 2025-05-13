package com.diboto.logitrack.repository;

import com.diboto.logitrack.model.EntregaSimulada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntregaSimuladaRepository extends JpaRepository<EntregaSimulada, Long> {
    // Buscar entregas por robô responsável
    List<EntregaSimulada> findByRoboResponsavelId(Long roboResponsavelId);

    // Consultas por status e prioridade
    List<EntregaSimulada> findByStatus(String status);
    List<EntregaSimulada> findByPrioridade(String prioridade);
}