package com.elildes.saude_backend.services;

import org.springframework.stereotype.Service;

import com.elildes.saude_backend.repositories.ConsultaRepository;

@Service
public class ConsultaService {

    final ConsultaRepository consultaRepository;

    public ConsultaService(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    
    
}
