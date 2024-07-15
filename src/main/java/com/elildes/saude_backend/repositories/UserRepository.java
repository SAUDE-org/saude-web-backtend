package com.elildes.saude_backend.repositories;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.elildes.saude_backend.models.Consulta;
import com.elildes.saude_backend.models.User;

@Repository
public class UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
