package com.elildes.saude_backend.models;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "consulta")
public class Consulta {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="consulta_seq")
    @SequenceGenerator(name="consulta_seq", sequenceName="consulta_seq", allocationSize=1)
    @Column(name = "id_consulta", nullable = false, unique = true)
    private Long id_consulta;

    @Column(name = "paciente")
    private Paciente paciente;

    @Column(name = "profissional")
    private Profissional profissional;

    @Column(name = "data")
    private LocalDate data;

    @Column(name = "horario")
    private LocalTime horario;

    @Column(name = "clinica")
    private Clinica clinica;

    public Consulta(){};

    public Consulta(Long id_consulta, Paciente paciente, Profissional profissional, LocalDate data, LocalTime horario,
            Clinica clinica) {
        this.id_consulta = id_consulta;
        this.paciente = paciente;
        this.profissional = profissional;
        this.data = data;
        this.horario = horario;
        this.clinica = clinica;
    }

    public Long getId_consulta() {
        return id_consulta;
    }

    public void setId_consulta(Long id_consulta) {
        this.id_consulta = id_consulta;
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

    public Clinica getClinica() {
        return clinica;
    }

    public void setClinica(Clinica clinica) {
        this.clinica = clinica;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id_consulta == null) ? 0 : id_consulta.hashCode());
        result = prime * result + ((paciente == null) ? 0 : paciente.hashCode());
        result = prime * result + ((profissional == null) ? 0 : profissional.hashCode());
        result = prime * result + ((data == null) ? 0 : data.hashCode());
        result = prime * result + ((horario == null) ? 0 : horario.hashCode());
        result = prime * result + ((clinica == null) ? 0 : clinica.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Consulta other = (Consulta) obj;
        if (id_consulta == null) {
            if (other.id_consulta != null)
                return false;
        } else if (!id_consulta.equals(other.id_consulta))
            return false;
        if (paciente == null) {
            if (other.paciente != null)
                return false;
        } else if (!paciente.equals(other.paciente))
            return false;
        if (profissional == null) {
            if (other.profissional != null)
                return false;
        } else if (!profissional.equals(other.profissional))
            return false;
        if (data == null) {
            if (other.data != null)
                return false;
        } else if (!data.equals(other.data))
            return false;
        if (horario == null) {
            if (other.horario != null)
                return false;
        } else if (!horario.equals(other.horario))
            return false;
        if (clinica == null) {
            if (other.clinica != null)
                return false;
        } else if (!clinica.equals(other.clinica))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Consulta [id_consulta=" + id_consulta + ", paciente=" + paciente + ", profissional=" + profissional
                + ", data=" + data + ", horario=" + horario + ", clinica=" + clinica + "]";
    }

    

}
