package com.elildes.saude_backend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.elildes.saude_backend.models.enums.Especialidade;

@Entity(name = "profissional")
public class Profissional {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pro_seq")
    @SequenceGenerator(name="pro_seq", sequenceName="pro_seq", allocationSize=1)
    @Column(name = "id_profissional", nullable = false, unique = true)
    private Long id_profissional;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cpf", nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(name = "email")
    private String email;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "registro_pro", nullable = false, unique = true)
    private String registro_pro;

    @Enumerated(EnumType.STRING)
    @Column(name = "especialidade")
    private Especialidade especialidade;

    public Profissional(){}    

    public Profissional(Long id_profissional, String nome, String cpf, String email, String telefone, String endereco,
            String registro_pro, Especialidade especialidade) {
        this.id_profissional = id_profissional;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.registro_pro = registro_pro;
        this.especialidade = especialidade;
    }

    public Long getId_profissional() {
        return id_profissional;
    }

    public void setId_profissional(Long id_profissional) {
        this.id_profissional = id_profissional;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getRegistro_pro() {
        return registro_pro;
    }

    public void setRegistro_pro(String registro_pro) {
        this.registro_pro = registro_pro;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id_profissional == null) ? 0 : id_profissional.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
        result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
        result = prime * result + ((registro_pro == null) ? 0 : registro_pro.hashCode());
        result = prime * result + ((especialidade == null) ? 0 : especialidade.hashCode());
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
        Profissional other = (Profissional) obj;
        if (id_profissional == null) {
            if (other.id_profissional != null)
                return false;
        } else if (!id_profissional.equals(other.id_profissional))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (telefone == null) {
            if (other.telefone != null)
                return false;
        } else if (!telefone.equals(other.telefone))
            return false;
        if (endereco == null) {
            if (other.endereco != null)
                return false;
        } else if (!endereco.equals(other.endereco))
            return false;
        if (registro_pro == null) {
            if (other.registro_pro != null)
                return false;
        } else if (!registro_pro.equals(other.registro_pro))
            return false;
        if (especialidade != other.especialidade)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Profissional [id_profissional=" + id_profissional + ", nome=" + nome + ", cpf=" + cpf + ", email="
                + email + ", telefone=" + telefone + ", endereco=" + endereco + ", registro_pro=" + registro_pro
                + ", especialidade=" + especialidade + "]";
    };

    

}
