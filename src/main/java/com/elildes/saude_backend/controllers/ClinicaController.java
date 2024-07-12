package com.elildes.saude_backend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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


}
