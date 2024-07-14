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
        // Extrair os dados do requestBody
        LocalDate data = LocalDate.parse((String) requestBody.get("data"), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalTime horario = LocalTime.parse((String) requestBody.get("horario"), DateTimeFormatter.ofPattern("HH:mm"));
        Long pacienteId = Long.parseLong((String) requestBody.get("pacienteId"));
        Long profissionalId = Long.parseLong((String) requestBody.get("profissionalId"));
        Long clinicaId = Long.parseLong((String) requestBody.get("clinicaId"));

        // Buscar entidades relacionadas
        Optional<Paciente> pacienteOpt = consultaService.buscarPacientePorId(pacienteId);
        Optional<Profissional> profissionalOpt = consultaService.buscarProfissionalPorId(profissionalId);
        Optional<Clinica> clinicaOpt = consultaService.buscarClinicaPorId(clinicaId);

        // Verificar se as entidades foram encontradas
        if (!pacienteOpt.isPresent() || !profissionalOpt.isPresent() || !clinicaOpt.isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        // Criar a consulta com os dados recuperados
        Consulta consulta = new Consulta();
        consulta.setData(data);
        consulta.setHorario(horario);
        consulta.setPaciente(pacienteOpt.get());
        consulta.setProfissional(profissionalOpt.get());
        consulta.setClinica(clinicaOpt.get());

        // Salvar a consulta
        Consulta novaConsulta = consultaService.salvarConsulta(consulta);
        return ResponseEntity.ok(novaConsulta);
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
