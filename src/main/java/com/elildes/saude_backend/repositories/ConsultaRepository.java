package com.elildes.saude_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elildes.saude_backend.models.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

}
