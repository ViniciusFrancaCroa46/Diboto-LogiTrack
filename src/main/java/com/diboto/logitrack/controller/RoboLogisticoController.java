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
    public List<Cliente> listarRobos() {
        return service.listarRobos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarRoboPorId(@PathVariable Long id) {
        Optional<Cliente> cliente = service.buscarRoboPorId(id);
        return cliente.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente criarCliente(@RequestBody Cliente cliente) {
        return service.salvarCliente(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody Cliente clienteAtualizado) {
        if (!service.existeCliente(id)) {
            return ResponseEntity.notFound().build();
        }
        clienteAtualizado.setId(id);
        return ResponseEntity.ok(service.salvarCliente(clienteAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removerCliente(@PathVariable Long id) {
        if (!service.excluirCliente(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Cliente excluído com sucesso!");
    }
}