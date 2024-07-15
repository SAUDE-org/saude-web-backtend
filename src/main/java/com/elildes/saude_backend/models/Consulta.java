package com.elildes.saude_backend.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity(name = "consulta")
public class Consulta implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="consulta_seq")
    @SequenceGenerator(name="consulta_seq", sequenceName="consulta_seq", allocationSize=1)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "dataTime")
    private LocalDateTime dataTime;

    @ManyToOne()
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @ManyToOne()
    @JoinColumn(name = "profissional_id")
    private Profissional profissional;

    @ManyToOne()
    @JoinColumn(name = "clinica_id")
    private Clinica clinica;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataTime() {
        return dataTime;
    }

    public void setDataTime(LocalDateTime dataTime) {
        this.dataTime = dataTime;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public Clinica getClinica() {
        return clinica;
    }

    public void setClinica(Clinica clinica) {
        this.clinica = clinica;
    }

    
    

}
