package com.elildes.saude_backend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elildes.saude_backend.models.Paciente;
import com.elildes.saude_backend.services.PacienteService;

@RestController
@RequestMapping("/paciente")
@CrossOrigin(origins = "*", maxAge = 3600)
public class PacienteController {

    private PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping("/inserir")
    public ResponseEntity<Paciente> inserirPaciente(@RequestBody Paciente paciente) {
        Paciente novoPaciente = pacienteService.salvarPaciente(paciente);
        return ResponseEntity.ok(novoPaciente);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Paciente>> getTodosPacientes() {
        List<Paciente> pacientes = pacienteService.buscarTodosPacientes();

        if (pacientes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.ok(pacientes);
        }
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Paciente> getPacientePorCpf(@PathVariable String cpf) {
        Optional<Paciente> paciente = pacienteService.buscarPacientePorCpf(cpf);
        return paciente.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

}
