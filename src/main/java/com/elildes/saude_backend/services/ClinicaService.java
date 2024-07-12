package com.elildes.saude_backend.services;

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


}
