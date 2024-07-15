package com.elildes.saude_backend.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Especialidade {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="esp_seq")
    @SequenceGenerator(name="esp_seq", sequenceName="esp_seq", allocationSize=1)
    @Column(name = "id_especialidade", nullable = false, unique = true)
    private Long id_especialidade;
    
    @Column(name = "nome")
    private String nome;

    @ManyToMany(mappedBy = "especialidades")
    private List<Profissional> profissionais;

    public Long getId_especialidade() {
        return id_especialidade;
    }

    public void setId_especialidade(Long id_especialidade) {
        this.id_especialidade = id_especialidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Profissional> getProfissionais() {
        return profissionais;
    }

    public void setProfissionais(List<Profissional> profissionais) {
        this.profissionais = profissionais;
    }

    
    
}
