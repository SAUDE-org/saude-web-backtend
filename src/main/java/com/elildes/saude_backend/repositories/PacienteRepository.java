package com.elildes.saude_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elildes.saude_backend.models.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}
