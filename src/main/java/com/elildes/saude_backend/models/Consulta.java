package com.elildes.saude_backend.models;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name = "consulta")
public class Consulta {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="consulta_seq")
    @SequenceGenerator(name="consulta_seq", sequenceName="consulta_seq", allocationSize=1)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "data")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate data;

    @Column(name = "horario")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime horario;

    @ManyToOne()
    @JoinColumn(name = "paciente_id")
    @JsonBackReference
    private Paciente paciente;

    @ManyToOne()
    @JoinColumn(name = "profissional_id")
    @JsonBackReference
    private Profissional profissional;

    @ManyToOne()
    @JoinColumn(name = "clinica_id")
    @JsonBackReference
    private Clinica clinica;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
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
