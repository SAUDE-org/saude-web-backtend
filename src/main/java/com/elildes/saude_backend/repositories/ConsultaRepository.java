package com.elildes.saude_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elildes.saude_backend.models.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

}
