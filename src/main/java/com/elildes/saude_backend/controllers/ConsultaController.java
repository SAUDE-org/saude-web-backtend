package com.elildes.saude_backend.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elildes.saude_backend.models.Consulta;
import com.elildes.saude_backend.services.ConsultaService;

import java.util.Optional;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    final ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
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

    @PostMapping("/inserir")
    public ResponseEntity<Consulta> inserirConsulta(@RequestBody Consulta consulta) {
        Consulta novaConsulta = consultaService.salvarConsulta(consulta);
        return ResponseEntity.ok(novaConsulta);
    }

}
