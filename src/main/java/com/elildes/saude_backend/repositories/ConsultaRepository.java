package com.elildes.saude_backend.repositories;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.elildes.saude_backend.models.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    // buscar a consulta com a data mais próxima
    // @Query("SELECT c FROM consulta c WHERE c.data >= :currentDate ORDER BY c.data ASC, c.horario ASC")
    // Optional<Consulta> findNextConsulta(@Param("currentDate") LocalDate currentDate);
}
