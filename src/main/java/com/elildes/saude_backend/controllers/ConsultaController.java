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
import com.elildes.saude_backend.models.ConsultaRequest;
import com.elildes.saude_backend.models.Paciente;
import com.elildes.saude_backend.models.Profissional;
import com.elildes.saude_backend.services.ConsultaService;

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

    // @PostMapping("/inserir")
    // public ResponseEntity<Consulta> inserirConsulta(@RequestBody Consulta consulta) {
    //     Consulta novaConsulta = consultaService.salvarconsulta(consulta);
    //     return ResponseEntity.ok(novaConsulta);
    // }

    @PostMapping("/inserir")
    public ResponseEntity<Consulta> inserirConsulta(@RequestBody ConsultaRequest consultaRequest) {
        Consulta consulta = new Consulta();
        consulta.setData(consultaRequest.getData());
        consulta.setHorario(consultaRequest.getHorario());

        if (consultaRequest.getPacienteId() != null) {
            Optional<Paciente> pacienteOpt = consultaService.buscarPacientePorId(consultaRequest.getPacienteId());
            pacienteOpt.ifPresent(consulta::setPaciente);
        }

        if (consultaRequest.getProfissionalId() != null) {
            Optional<Profissional> profissionalOpt = consultaService.buscarProfissionalPorId(consultaRequest.getProfissionalId());
            profissionalOpt.ifPresent(consulta::setProfissional);
        }

        if (consultaRequest.getClinicaId() != null) {
            Optional<Clinica> clinicaOpt = consultaService.buscarClinicaPorId(consultaRequest.getClinicaId());
            clinicaOpt.ifPresent(consulta::setClinica);
        }

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
