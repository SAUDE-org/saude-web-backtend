package com.elildes.saude_backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.elildes.saude_backend.models.Clinica;
import com.elildes.saude_backend.repositories.ClinicaRepository;

@Service
public class ClinicaService {

    private ClinicaRepository clinicaRepository;

    public ClinicaService(ClinicaRepository clinicaRepository) {
        this.clinicaRepository = clinicaRepository;
    }

    // salvar clínica
    public Clinica salvarClinica(Clinica clinica) {
        return clinicaRepository.save(clinica);
    }

    // buscar todas clínicas
    public List<Clinica> buscarTodasClinicas() {
        return clinicaRepository.findAll();
    }

    // buscar clínica por cnpj
    public Optional<Clinica> buscarClinicaPorCnpj(String cnpj) {
        return clinicaRepository.findByCnpj(cnpj);
    }


}
