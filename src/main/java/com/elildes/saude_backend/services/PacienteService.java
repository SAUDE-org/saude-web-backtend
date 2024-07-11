package com.elildes.saude_backend.services;

import org.springframework.stereotype.Service;

import com.elildes.saude_backend.models.Paciente;
import com.elildes.saude_backend.repositories.PacienteRepository;

@Service
public class PacienteService {

    private PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    // salvar paciente
    public Paciente salvarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }
    
}
