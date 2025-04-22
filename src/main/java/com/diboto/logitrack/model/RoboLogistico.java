package com.diboto.logitrack.model;

import jakarta.persistence.*;

@Entity
@Table(name = "RoboLogistico")
public class RoboLogistico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String status;
    private Double nivelEnergia;
    private String modelo;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {this.nome = nome;}
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Double getNivelEnergia() {
        return nivelEnergia;
    }
    public void setNivelEnergia(Double nivelEnergia) {
        this.nivelEnergia = nivelEnergia;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
