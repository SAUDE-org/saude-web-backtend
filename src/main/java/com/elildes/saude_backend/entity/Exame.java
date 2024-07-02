package com.elildes.saude_backend.entity;

// import java.time.LocalDate;
// import java.time.LocalTime;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.EnumType;
// import jakarta.persistence.Enumerated;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;

// @Entity(name = "exame")
public class Exame {
    
    // @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    // @Column(name = "id_exame", nullable = false, unique = true)
    // private Long id_exame;

    // @Column(name = "nome")
    // private String nome;

    // @Column(name = "paciente")
    // private Paciente paciente;

    // @Column(name = "data")
    // private LocalDate data;

    // @Column(name = "horario")
    // private LocalTime horario;

    // @Column(name = "clinica")
    // private Clinica clinica;

    // @Enumerated(EnumType.STRING)
    // @Column(name = "status_exame")
    // private StatusExame status_exame;

    // public Exame(){};

    // public Exame(Long id_exame, String nome, Paciente paciente, LocalDate data, LocalTime horario, Clinica clinica,
    //         StatusExame status_exame) {
    //     this.id_exame = id_exame;
    //     this.nome = nome;
    //     this.paciente = paciente;
    //     this.data = data;
    //     this.horario = horario;
    //     this.clinica = clinica;
    //     this.status_exame = status_exame;
    // }

    // public Long getId_exame() {
    //     return id_exame;
    // }

    // public void setId_exame(Long id_exame) {
    //     this.id_exame = id_exame;
    // }

    // public String getNome() {
    //     return nome;
    // }

    // public void setNome(String nome) {
    //     this.nome = nome;
    // }

    // public Paciente getPaciente() {
    //     return paciente;
    // }

    // public void setPaciente(Paciente paciente) {
    //     this.paciente = paciente;
    // }

    // public LocalDate getData() {
    //     return data;
    // }

    // public void setData(LocalDate data) {
    //     this.data = data;
    // }

    // public LocalTime getHorario() {
    //     return horario;
    // }

    // public void setHorario(LocalTime horario) {
    //     this.horario = horario;
    // }

    // public Clinica getClinica() {
    //     return clinica;
    // }

    // public void setClinica(Clinica clinica) {
    //     this.clinica = clinica;
    // }

    // public StatusExame getStatus_exame() {
    //     return status_exame;
    // }

    // public void setStatus_exame(StatusExame status_exame) {
    //     this.status_exame = status_exame;
    // }

    // @Override
    // public int hashCode() {
    //     final int prime = 31;
    //     int result = 1;
    //     result = prime * result + ((id_exame == null) ? 0 : id_exame.hashCode());
    //     result = prime * result + ((nome == null) ? 0 : nome.hashCode());
    //     result = prime * result + ((paciente == null) ? 0 : paciente.hashCode());
    //     result = prime * result + ((data == null) ? 0 : data.hashCode());
    //     result = prime * result + ((horario == null) ? 0 : horario.hashCode());
    //     result = prime * result + ((clinica == null) ? 0 : clinica.hashCode());
    //     result = prime * result + ((status_exame == null) ? 0 : status_exame.hashCode());
    //     return result;
    // }

    // @Override
    // public boolean equals(Object obj) {
    //     if (this == obj)
    //         return true;
    //     if (obj == null)
    //         return false;
    //     if (getClass() != obj.getClass())
    //         return false;
    //     Exame other = (Exame) obj;
    //     if (id_exame == null) {
    //         if (other.id_exame != null)
    //             return false;
    //     } else if (!id_exame.equals(other.id_exame))
    //         return false;
    //     if (nome == null) {
    //         if (other.nome != null)
    //             return false;
    //     } else if (!nome.equals(other.nome))
    //         return false;
    //     if (paciente == null) {
    //         if (other.paciente != null)
    //             return false;
    //     } else if (!paciente.equals(other.paciente))
    //         return false;
    //     if (data == null) {
    //         if (other.data != null)
    //             return false;
    //     } else if (!data.equals(other.data))
    //         return false;
    //     if (horario == null) {
    //         if (other.horario != null)
    //             return false;
    //     } else if (!horario.equals(other.horario))
    //         return false;
    //     if (clinica == null) {
    //         if (other.clinica != null)
    //             return false;
    //     } else if (!clinica.equals(other.clinica))
    //         return false;
    //     if (status_exame != other.status_exame)
    //         return false;
    //     return true;
    // }

    // @Override
    // public String toString() {
    //     return "Exame [id_exame=" + id_exame + ", nome=" + nome + ", paciente=" + paciente + ", data=" + data
    //             + ", horario=" + horario + ", clinica=" + clinica + ", status_exame=" + status_exame
    //             + ", getId_exame()=" + getId_exame() + ", getClass()=" + getClass() + ", getNome()=" + getNome()
    //             + ", getPaciente()=" + getPaciente() + ", getData()=" + getData() + ", getHorario()=" + getHorario()
    //             + ", getClinica()=" + getClinica() + ", getStatus_exame()=" + getStatus_exame() + ", hashCode()="
    //             + hashCode() + ", toString()=" + super.toString() + "]";
    // }
    
}
