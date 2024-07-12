package com.elildes.saude_backend.services;

import org.springframework.stereotype.Service;

import com.elildes.saude_backend.models.Profissional;
import com.elildes.saude_backend.repositories.ProfissionalRepository;

@Service
public class ProfissionalService {

    private ProfissionalRepository profissionalRepository;

    public ProfissionalService(ProfissionalRepository profissionalRepository) {
        this.profissionalRepository = profissionalRepository;
    }

    // salvar profissional
    public Profissional salvarProfissional(Profissional profissional) {
        return profissionalRepository.save(profissional);
    }


}
