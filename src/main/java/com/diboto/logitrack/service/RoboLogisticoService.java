package com.diboto.logitrack.service;

import com.diboto.logitrack.model.RoboLogistico;
import com.diboto.logitrack.repository.RoboLogisticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoboLogisticoService {

    @Autowired
    private RoboLogisticoRepository repository;

    public List<RoboLogistico> listarRoboLogistico(){
        return repository.findAll();
    }

    public Optional<RoboLogistico> buscarRoboLogisticoPorId(Long id){
        return repository.findById(id);
    }

    public RoboLogistico salvarRoboLogistico (RoboLogistico roboLogistico){
        return repository.save(roboLogistico);
    }

    public boolean existeRoboLogistico(Long id){
        return repository.existsById(id);
    }

    public boolean excluirRoboLogistico(Long id){
        if (repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }

}
