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

import com.elildes.saude_backend.models.Clinica;
import com.elildes.saude_backend.services.ClinicaService;

@RestController
@RequestMapping("/clinica")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ClinicaController {

    private ClinicaService clinicaService;

    public ClinicaController(ClinicaService clinicaService) {
        this.clinicaService = clinicaService;
    }

    @PostMapping("/inserir")
    public ResponseEntity<Clinica> inserirClinica(@RequestBody Clinica clinica) {
        Clinica novaClinica = clinicaService.salvarClinica(clinica);
        return ResponseEntity.ok(novaClinica);
    }

    @GetMapping("/todas")
    public ResponseEntity<List<Clinica>> getTodasClinicas() {
        List<Clinica> clinicas = clinicaService.buscarTodasClinicas();

        if (clinicas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.ok(clinicas);
        }
    }

    @GetMapping("/cnpj/{cnpj}")
    public ResponseEntity<Clinica> getClinicaPorCnpj(@PathVariable String cnpj) {
        Optional<Clinica> clinica = clinicaService.buscarClinicaPorCnpj(cnpj);
        return clinica.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }


}
