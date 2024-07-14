package com.elildes.saude_backend.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

    @OneToMany(mappedBy = "profissional")
    private List<Consulta> consultas;

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

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    

}
