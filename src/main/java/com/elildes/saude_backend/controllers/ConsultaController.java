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

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;
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
    public ResponseEntity<Consulta> inserirConsulta(@RequestBody Map<String, Object> requestBody) {
        try {
            // Extrair os dados do requestBody
            LocalDate data = LocalDate.parse((String) requestBody.get("data"), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            LocalTime horario = LocalTime.parse((String) requestBody.get("horario"), DateTimeFormatter.ofPattern("HH:mm"));
            Long pacienteId = requestBody.get("pacienteId") != null ? Long.parseLong((String) requestBody.get("pacienteId")) : null;
            Long profissionalId = requestBody.get("profissionalId") != null ? Long.parseLong((String) requestBody.get("profissionalId")) : null;
            Long clinicaId = requestBody.get("clinicaId") != null ? Long.parseLong((String) requestBody.get("clinicaId")) : null;

            // Se pacienteId, profissionalId ou clinicaId forem nulos, a consulta será salva sem associação
            Consulta consulta = new Consulta();
            consulta.setData(data);
            consulta.setHorario(horario);

            if (pacienteId != null) {
                Optional<Paciente> pacienteOpt = consultaService.buscarPacientePorId(pacienteId);
                pacienteOpt.ifPresent(consulta::setPaciente);
            }

            if (profissionalId != null) {
                Optional<Profissional> profissionalOpt = consultaService.buscarProfissionalPorId(profissionalId);
                profissionalOpt.ifPresent(consulta::setProfissional);
            }

            if (clinicaId != null) {
                Optional<Clinica> clinicaOpt = consultaService.buscarClinicaPorId(clinicaId);
                clinicaOpt.ifPresent(consulta::setClinica);
            }

            // Salvar a consulta
            Consulta novaConsulta = consultaService.salvarConsulta(consulta);
            return ResponseEntity.ok(novaConsulta);
        } catch (DateTimeParseException | NumberFormatException e) {
            // Caso ocorra algum erro de parsing ou conversão
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

    @GetMapping("/find-next")
    public ResponseEntity<Consulta> findNextConsulta() {
        Optional<Consulta> nextConsulta = consultaService.findNextConsulta();
        if (nextConsulta.isPresent()) {
            return ResponseEntity.ok(nextConsulta.get());
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

}
