package com.elildes.saude_backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name = "profissional")
public class Profissional extends Pessoa {
    
    @Id
    @GeneratedValue
    @Column(name = "id_profissional", nullable = false, unique = true)
    private String id_profissional;

    @Column(name = "registro_pro", nullable = false, unique = true)
    private String registro_pro;

    @Enumerated(EnumType.STRING)
    @Column(name = "especialidade")
    private Especialidade especialidade;

    public Profissional(){};

    public Profissional(String id_profissional, String registro_pro) {
        this.id_profissional = id_profissional;
        this.registro_pro = registro_pro;
    }

    public Profissional(Long id_pessoa, String nome, String cpf, String email, String telefone, String endereco,
            String id_profissional, String registro_pro) {
        super(id_pessoa, nome, cpf, email, telefone, endereco);
        this.id_profissional = id_profissional;
        this.registro_pro = registro_pro;
    }

    public String getRegistro_pro() {
        return registro_pro;
    }

    public String getId_profissional() {
        return id_profissional;
    }

    public void setId_profissional(String id_profissional) {
        this.id_profissional = id_profissional;
    }

    public void setRegistro_pro(String registro_pro) {
        this.registro_pro = registro_pro;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((id_profissional == null) ? 0 : id_profissional.hashCode());
        result = prime * result + ((registro_pro == null) ? 0 : registro_pro.hashCode());
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
        Profissional other = (Profissional) obj;
        if (id_profissional == null) {
            if (other.id_profissional != null)
                return false;
        } else if (!id_profissional.equals(other.id_profissional))
            return false;
        if (registro_pro == null) {
            if (other.registro_pro != null)
                return false;
        } else if (!registro_pro.equals(other.registro_pro))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Profissional [id_profissional=" + id_profissional + ", registro_pro=" + registro_pro
                + ", getId_pessoa()=" + getId_pessoa() + ", getRegistro_pro()=" + getRegistro_pro()
                + ", getId_profissional()=" + getId_profissional() + ", getNome()=" + getNome() + ", getCpf()="
                + getCpf() + ", hashCode()=" + hashCode() + ", getEmail()=" + getEmail() + ", getClass()=" + getClass()
                + ", getTelefone()=" + getTelefone() + ", getEndereco()=" + getEndereco() + ", toString()="
                + super.toString() + "]";
    }

}
