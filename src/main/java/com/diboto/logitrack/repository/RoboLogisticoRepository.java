package com.diboto.logitrack.repository;

import com.diboto.logitrack.model.RoboLogistico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoboLogisticoRepository extends JpaRepository<RoboLogistico, Long> {
    // Exemplo de consultas customizadas
    List<RoboLogistico> findByStatus(String status);
    List<RoboLogistico> findByModelo(String modelo);
}