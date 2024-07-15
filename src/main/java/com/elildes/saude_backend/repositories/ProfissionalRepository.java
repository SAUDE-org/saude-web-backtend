package com.elildes.saude_backend.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elildes.saude_backend.models.Profissional;

@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {

    @EntityGraph(attributePaths = "especialidades")
    List<Profissional> findAll();
    
    @EntityGraph(attributePaths = "especialidades")
    Optional<Profissional> findByCpf(String cpf);

    @EntityGraph(attributePaths = "especialidades")
    Optional<Profissional> findById(Long id);
}
