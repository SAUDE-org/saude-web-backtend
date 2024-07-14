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

import com.elildes.saude_backend.models.Profissional;
import com.elildes.saude_backend.services.ProfissionalService;

@RestController
@RequestMapping("/profissional")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProfissionalController {

    private ProfissionalService profissionalService;

    public ProfissionalController(ProfissionalService profissionalService) {
        this.profissionalService = profissionalService;
    }

    @PostMapping("/inserir")
    public ResponseEntity<Profissional> inserirProfissional(@RequestBody Profissional profissional) {
        try {
            Profissional novoProfissional = profissionalService.salvarProfissional(profissional);
            return new ResponseEntity<>(novoProfissional, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Profissional>> getTodosProfissionais() {
        List<Profissional> profissionais = profissionalService.buscarTodosProfissionais();

        if(profissionais.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.ok(profissionais);
        }
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Profissional> getProfissionalPorCpf(@PathVariable String cpf) {
        Optional<Profissional> profissional = profissionalService.buscarProfissionalPorCpf(cpf);
        return profissional.map(ResponseEntity::ok)
                           .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profissional> getProfissionalPorId(@PathVariable Long id) {
        Optional<Profissional> profissional = profissionalService.buscarProfissionalPorId(id);
        return profissional.map(ResponseEntity::ok)
                           .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    
}
