package com.diboto.logitrack.controller;

import com.diboto.logitrack.model.EventoSensorial;
import com.diboto.logitrack.service.EventoSensorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/logitrack/eventosensorial")
public class EventoSensorialController {

    @Autowired
    private EventoSensorialService dispositivoService;

    @GetMapping
    public List<EventoSensorial> listaEventoSensorial() {
        return EventoSensorialService.listaEventoSensorial();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoSensorial> buscarEventoSensorialPorId(@PathVariable Long id) {
        Optional<EventoSensorial> eventoSensorial = EventoSensorialService.buscarEventoSensorialPorId(id);
        return eventoSensorial.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/EventoSensorial/{RoboLogisticoId}")
    public List<EventoSensorial> listarEventoSensorialPorRoboLogistico(@PathVariable Long EventoSensorialId) {
        return dispositivoService.listarEventoSensorialPorRoboLogistico(RoboLogisticoId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EventoSensorial criarEventoSensorial(@RequestBody EventoSensorial eventoSensorial) {
        return dispositivoService.salvarEventoSensorial(eventoSensorial);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventoSensorial> atualizarEventoSensorial(@PathVariable Long id, @RequestBody EventoSensorial eventoSensorialAtualizado) {
        if (!EventoSensorialService.existeEventoSensorial(id)) {
            return ResponseEntity.notFound().build();
        }
        eventoSensorialAtualizado.setId(id);
        return ResponseEntity.ok(EventoSensorialService.salvarEventoSensorial(eventoSensorialAtualizado));
    }

    @PatchMapping("/{id}/colisão")
    public ResponseEntity<EventoSensorial> ajustarColisao(@PathVariable Long id) {
        return dispositivoService.alterarRegistroColisao(id, true)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}/obstaculo")
    public ResponseEntity<EventoSensorial> ajustarObstaculo(@PathVariable Long id) {
        return EventoSensorialService.alterarRegistroObstaculo(id, false)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}/desvio")
    public ResponseEntity<EventoSensorial> ajustarDesvio(@PathVariable Long id, @RequestBody Map<String, Integer> payload) {
        Integer desvio = payload.get("desvio");
        if (desvio == null) {
            return ResponseEntity.badRequest().build();
        }

        return eventoSensorialService.ajustardesvio(id, desvio)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removerEventoSensorial(@PathVariable Long id) {
        if (!eventoSensorialService.existeEventoSensorial(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("EventoSensorial não encontrado.");
        }
        eventoSensorialService.excluirEventoSensorial(id);
        return ResponseEntity.status(HttpStatus.OK).body("EventoSensorial excluído com sucesso!");
    }
}