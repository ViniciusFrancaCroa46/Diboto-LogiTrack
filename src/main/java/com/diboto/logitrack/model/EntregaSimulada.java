package com.diboto.logitrack.model;

import jakarta.persistence.*;

@Entity
@Table(name = "EntregaSimulada")
public class EntregaSimulada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String origem;
    private String destino;
    private String prioridade;
    private String status;
    private Long roboResponsavelId;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getOrigem() {
        return origem;
    }
    public void setOrigem(String origem) {
        this.origem = origem;
    }
    public String getDestino() {
        return destino;
    }
    public void setDestino(String destino) {
        this.destino = destino;
    }
    public String getPrioridade() {
        return prioridade;
    }
    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Long getRoboResponsavelId() {
        return roboResponsavelId;
    }
    public void setRoboResponsavelId(Long roboResponsavelId) {
        this.roboResponsavelId = roboResponsavelId;
    }
}
