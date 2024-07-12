package com.elildes.saude_backend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elildes.saude_backend.models.Profissional;
import com.elildes.saude_backend.services.ProfissionalService;

@RestController
@RequestMapping("/profissioanl")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProfissionalController {

    private ProfissionalService profissionalService;

    public ProfissionalController(ProfissionalService profissionalService) {
        this.profissionalService = profissionalService;
    }

    @PostMapping("/inserir")
    public ResponseEntity<Profissional> inserirProfissional(@RequestBody Profissional profissional) {
        Profissional novoProfissional = profissionalService.salvarProfissional(profissional);
        return ResponseEntity.ok(novoProfissional);
    }


}
