package com.elildes.saude_backend.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elildes.saude_backend.models.Clinica;
import com.elildes.saude_backend.models.Consulta;
import com.elildes.saude_backend.models.Paciente;
import com.elildes.saude_backend.models.Profissional;
import com.elildes.saude_backend.services.ConsultaService;

import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/consulta")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ConsultaController {

    final ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @PostMapping("/inserir")
    public ResponseEntity<Consulta> inserirConsulta(@RequestBody Consulta consulta) {
        try {
            // Verificar se os IDs estão presentes e buscar os objetos relacionados
            if (consulta.getPaciente() != null && consulta.getPaciente().getId() != null) {
                Optional<Paciente> pacienteOpt = consultaService.buscarPacientePorId(consulta.getPaciente().getId());
                pacienteOpt.ifPresent(consulta::setPaciente);
            }

            if (consulta.getProfissional() != null && consulta.getProfissional().getId() != null) {
                Optional<Profissional> profissionalOpt = consultaService.buscarProfissionalPorId(consulta.getProfissional().getId());
                profissionalOpt.ifPresent(consulta::setProfissional);
            }

            if (consulta.getClinica() != null && consulta.getClinica().getId() != null) {
                Optional<Clinica> clinicaOpt = consultaService.buscarClinicaPorId(consulta.getClinica().getId());
                clinicaOpt.ifPresent(consulta::setClinica);
            }

            // Salvar a consulta
            Consulta novaConsulta = consultaService.salvarConsulta(consulta);
            return ResponseEntity.ok(novaConsulta);
        } catch (DateTimeParseException | NumberFormatException e) {
            // Caso ocorra algum erro
            return ResponseEntity.badRequest().build();
        }
    }  

    @GetMapping("/todas")
    public ResponseEntity<List<Consulta>> getTodasConsultas() {
        List<Consulta> consultas = consultaService.buscarTodasConsultas();

        if (consultas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.ok(consultas);
        }
    }

    // @GetMapping("/find-next")
    // public ResponseEntity<Consulta> findNextConsulta() {
    //     Optional<Consulta> nextConsulta = consultaService.findNextConsulta();
    //     if (nextConsulta.isPresent()) {
    //         return ResponseEntity.ok(nextConsulta.get());
    //     } else {
    //         return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    //     }
    // }

}
