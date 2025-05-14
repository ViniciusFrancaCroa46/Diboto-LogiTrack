package com.diboto.logitrack.controller;

import com.diboto.logitrack.model.RoboLogistico;
import com.diboto.logitrack.service.RoboLogisticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/RoboLogistico")
public class RoboLogisticoController {

    @Autowired
    private RoboLogisticoService service;

    @GetMapping
    public List<RoboLogistico> listarRobos() {
        return service.listarRoboLogistico();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoboLogistico> buscarRoboLogisticoPorId(@PathVariable Long id) {
        Optional<RoboLogistico> roboLogistico = service.buscarRoboLogisticoPorId(id);
        return roboLogistico.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RoboLogistico criarRoboLogistico(@RequestBody RoboLogistico roboLogistico) {
        return service.salvarRoboLogistico(roboLogistico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoboLogistico> atualizarRoboLogistico(@PathVariable Long id, @RequestBody RoboLogistico roboLogisticoAtualizado) {
        if (!service.existeRoboLogistico(id)) {
            return ResponseEntity.notFound().build();
        }
        roboLogisticoAtualizado.setId(id);
        return ResponseEntity.ok(service.salvarRoboLogistico(roboLogisticoAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removerRoboLogistico(@PathVariable Long id) {
        if (!service.excluirRoboLogistico(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Robo Logistico não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Robo Logistico excluído com sucesso!");
    }
}