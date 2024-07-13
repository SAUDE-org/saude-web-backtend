package com.elildes.saude_backend.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.elildes.saude_backend.models.Consulta;
import com.elildes.saude_backend.repositories.ConsultaRepository;

@Service
public class ConsultaService {

    final ConsultaRepository consultaRepository;

    public ConsultaService(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    // salvar consulta
    public Consulta salvarconsulta(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    // buscar todas consultas
    public List<Consulta> buscarTodasConsultas() {
        return consultaRepository.findAll();
    }

    // buscar a consulta com a data mais próxima
    public Optional<Consulta> findNextConsulta() {
        LocalDate today = LocalDate.now();
        return consultaRepository.findNextConsulta(today);
    }
    
}
