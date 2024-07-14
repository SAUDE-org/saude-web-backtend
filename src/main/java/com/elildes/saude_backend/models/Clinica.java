package com.elildes.saude_backend.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;



@Entity(name = "clinica")
public class Clinica {
    
    @Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="clinica_seq")
	@SequenceGenerator(name="clinica_seq", sequenceName="clinica_seq", allocationSize=1)
    @Column(name = "id_clinica", nullable = false, unique = true)
    private Long id_clinica;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cnpj", nullable = false, length = 14)
    private String cnpj;

    @Column(name = "email")
    private String email;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "endereco")
    private String endereco;

    @OneToMany(mappedBy = "clinica")
    private List<Consulta> consultas;

    public Long getId_clinica() {
        return id_clinica;
    }

    public void setId_clinica(Long id_clinica) {
        this.id_clinica = id_clinica;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    

}
