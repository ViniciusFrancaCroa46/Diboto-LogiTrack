package com.diboto.logitrack.controller;

import com.diboto.logitrack.model.EntregaSimulada;
import com.diboto.logitrack.service.EntregaSimuladaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/logitrack/entregaSimulada")
public class EntregaSimuladaController {

    @Autowired
    private EntregaSimuladaService entregaSimuladaService;

    @GetMapping
    public List<EntregaSimulada> listarEntregaSimulada() {
        return entregaSimuladaService.listaEntregas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntregaSimulada> buscarEntregaSimuladaPorId(@PathVariable Long id) {
        Optional<EntregaSimulada> entregaSimulada = entregaSimuladaService.buscaEntregaPorId(id);
        return entregaSimulada.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntregaSimulada criarAmbiente(@RequestBody EntregaSimulada entregaSimulada) {
        return entregaSimuladaService.salvaEntrega(entregaSimulada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntregaSimulada> atualizarEntregaSimulada(@PathVariable Long id, @RequestBody EntregaSimulada entregaSimuladaAtualizado) {
        if (!entregaSimuladaService.existeEntrega(id)) {
            return ResponseEntity.notFound().build();
        }
        entregaSimuladaAtualizado.setId(id);
        return ResponseEntity.ok(entregaSimuladaService.salvaEntrega(entregaSimuladaAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removerEntregaSimulada(@PathVariable Long id) {
        if (!entregaSimuladaService.existeEntrega(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entrega Simulada não encontrado.");
        }
        entregaSimuladaService.excluirEntrega(id);
        return ResponseEntity.status(HttpStatus.OK).body("Entrega Simulada excluído com sucesso!");
    }
}