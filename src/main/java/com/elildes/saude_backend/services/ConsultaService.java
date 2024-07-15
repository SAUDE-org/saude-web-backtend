package com.elildes.saude_backend.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.elildes.saude_backend.models.Clinica;
import com.elildes.saude_backend.models.Consulta;
import com.elildes.saude_backend.models.Paciente;
import com.elildes.saude_backend.models.Profissional;
import com.elildes.saude_backend.repositories.ClinicaRepository;
import com.elildes.saude_backend.repositories.ConsultaRepository;
import com.elildes.saude_backend.repositories.PacienteRepository;
import com.elildes.saude_backend.repositories.ProfissionalRepository;

@Service
public class ConsultaService {

    private ConsultaRepository consultaRepository;

    public ConsultaService(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    // private PacienteRepository pacienteRepository;

    // private ProfissionalRepository profissionalRepository;

    // private ClinicaRepository clinicaRepository;   

    // public ConsultaService(ConsultaRepository consultaRepository, PacienteRepository pacienteRepository,
    //         ProfissionalRepository profissionalRepository, ClinicaRepository clinicaRepository) {
    //     this.consultaRepository = consultaRepository;
    //     this.pacienteRepository = pacienteRepository;
    //     this.profissionalRepository = profissionalRepository;
    //     this.clinicaRepository = clinicaRepository;
    // }

    // salvar consulta
    public Consulta salvarConsulta(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    // buscar paciente por id
    // public Optional<Paciente> buscarPacientePorId(Long pacienteId) {
    //     return pacienteRepository.findById(pacienteId);
    // }

    // buscar profissional por id 
    // public Optional<Profissional> buscarProfissionalPorId(Long profissionalId) {
    //     return profissionalRepository.findById(profissionalId);
    // }

    // buscar clinica por id
    // public Optional<Clinica> buscarClinicaPorId(Long clinicaId) {
    //     return clinicaRepository.findById(clinicaId);
    // }

    // buscar todas consultas
    public List<Consulta> buscarTodasConsultas() {
        return consultaRepository.findAll();
    }    

    // buscar a consulta com a data mais próxima
    // public Optional<Consulta> findNextConsulta() {
    //     LocalDate today = LocalDate.now();
    //     return consultaRepository.findNextConsulta(today);
    // }

    
}
