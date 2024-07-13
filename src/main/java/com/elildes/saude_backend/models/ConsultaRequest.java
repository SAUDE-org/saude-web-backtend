package com.elildes.saude_backend.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class ConsultaRequest {

    private LocalDate data;
    private LocalTime horario;
    private Long pacienteId;
    private Long profissionalId;
    private Long clinicaId;

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

    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
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
