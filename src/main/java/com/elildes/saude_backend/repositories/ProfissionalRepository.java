package com.elildes.saude_backend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elildes.saude_backend.models.Profissional;

@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {

    Optional<Profissional> findByCpf(String cpf);
}
