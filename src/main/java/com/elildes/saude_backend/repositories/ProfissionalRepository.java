package com.elildes.saude_backend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elildes.saude_backend.models.User;

@Repository
public interface ProfissionalRepository extends JpaRepository<User, Long> {

    Optional<User> findByCpf(String cpf);
}
