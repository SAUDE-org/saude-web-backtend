package com.elildes.saude_backend.models;

import java.io.Serializable;
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
public class Especialidade implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="esp_seq")
    @SequenceGenerator(name="esp_seq", sequenceName="esp_seq", allocationSize=1)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    
    @Column(name = "nome")
    private String nome;

    @ManyToMany(mappedBy = "especialidades")
    @JsonIgnore
    private List<Profissional> profissionais;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
