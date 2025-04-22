package com.diboto.logitrack.service;

import com.diboto.logitrack.model.EntregaSimulada;
import com.diboto.logitrack.repository.EntregaSimuladaRepository;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class EntregaSimuladaService {
    @Autowired
    private EntregaSimuladaService entregaSimuladaService;

    public List<EntregaSimulada> listaEntregas() {
        return repository.findAll();
    }

    public Optional<EntregaSimulada> buscaEntregaPorId(Long id) {
        return repository.findById(id);
    }

    public EntregaSimulada salvaEntrega(EntregaSimulada entrega) {
        return repository.save(entrega);
    }

    public boolean existeEntrega(Long id) {
        return repository.existsById(id);
    }

    public boolean excluirEntrega(Long id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
