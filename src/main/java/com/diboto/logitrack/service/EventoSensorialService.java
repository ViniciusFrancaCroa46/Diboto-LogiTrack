package com.diboto.logitrack.service;

import com.diboto.logitrack.model.EventoSensorial;
import com.diboto.logitrack.repository.EventoSensorialRepository;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public class EventoSensorialService {
    @Autowired
    private EventoSensorialService eventoSensorialService;

    public list<EventoSensorial> listaEventoSensorial(){
        return repository.findAll();
    }

    public Optional<EventoSensorial> buscarEventoSensorialPorId(Long id){
        return repository.findById(id);
    }

    public EventoSensorial salvarEventoSensorial(EventoSensorial eventoSensorial){
        return repository.save(eventoSensorial);
    }

    public boolean existeEventoSensorial(Long id) {
        return repository.existsById(id);
    }

    public boolean excluirEventoSensorial(Long id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}