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

    //@ManyToOne()
    @JoinColumn(name = "paciente_id")
    private Long paciente;

    //@ManyToOne()
    @JoinColumn(name = "profissional_id")
    private Long profissionalId;

    //@ManyToOne()
    @JoinColumn(name = "clinica_id")
    private Long clinicaId;

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

    public Long getPaciente() {
        return paciente;
    }

    public void setPaciente(Long paciente) {
        this.paciente = paciente;
    }

    public Long getProfissionalId() {
        return profissionalId;
    }

    public void setProfissionalId(Long profissionalId) {
        this.profissionalId = profissionalId;
    }

    public Long getClinicaId() {
        return clinicaId;
    }

    public void setClinicaId(Long clinicaId) {
        this.clinicaId = clinicaId;
    }

    
}
