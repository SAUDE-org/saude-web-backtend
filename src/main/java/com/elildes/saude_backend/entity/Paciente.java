package com.elildes.saude_backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "paciente")
public class Paciente extends Pessoa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_paciente", nullable = false, unique = true)
    private Long id_paciente;

    public Paciente(){};

    public Paciente(Long id_paciente) {
        this.id_paciente = id_paciente;
    }

    public Paciente(Long id_pessoa, String nome, String cpf, String email, String telefone, String endereco,
            Long id_paciente) {
        super(id_pessoa, nome, cpf, email, telefone, endereco);
        this.id_paciente = id_paciente;
    }

    public Long getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(Long id_paciente) {
        this.id_paciente = id_paciente;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((id_paciente == null) ? 0 : id_paciente.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Paciente other = (Paciente) obj;
        if (id_paciente == null) {
            if (other.id_paciente != null)
                return false;
        } else if (!id_paciente.equals(other.id_paciente))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Paciente [id_paciente=" + id_paciente + ", getId_paciente()=" + getId_paciente() + ", hashCode()="
                + hashCode() + ", getId_pessoa()=" + getId_pessoa() + ", getNome()=" + getNome() + ", getCpf()="
                + getCpf() + ", getEmail()=" + getEmail() + ", getClass()=" + getClass() + ", getTelefone()="
                + getTelefone() + ", getEndereco()=" + getEndereco() + ", toString()=" + super.toString() + "]";
    }

}
