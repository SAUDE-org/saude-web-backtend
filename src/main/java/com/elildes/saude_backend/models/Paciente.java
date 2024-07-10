package com.elildes.saude_backend.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity(name = "paciente")
public class Paciente {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="paciente_seq")
	@SequenceGenerator(name="paciente_seq", sequenceName="paciente_seq", allocationSize=1)
    @Column(name = "id_paciente", nullable = false, unique = true)
    private Long id_paciente;

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

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Consulta> consultas = new HashSet<>();

    public Long getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(Long id_paciente) {
        this.id_paciente = id_paciente;
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

    public Set<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(Set<Consulta> consultas) {
        this.consultas = consultas;
    }
    
    // Métodos adicionais para adicionar e remover consultas
    public void addConsulta(Consulta consulta) {
        consultas.add(consulta);
        consulta.setPaciente(this);
    }

    public void removeConsulta(Consulta consulta) {
        consultas.remove(consulta);
        consulta.setPaciente(null);
    }

    // hash_code

    // to_string
    
    
}
