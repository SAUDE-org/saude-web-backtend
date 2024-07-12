package com.elildes.saude_backend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elildes.saude_backend.models.Clinica;

@Repository
public interface ClinicaRepository extends JpaRepository<Clinica, Long> {

    Optional<Clinica> findByCnpj(String cnpj);
}
