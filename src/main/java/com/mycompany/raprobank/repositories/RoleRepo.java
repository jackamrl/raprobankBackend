package com.mycompany.raprobank.repositories;

import com.mycompany.raprobank.entities.ERole;
import com.mycompany.raprobank.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
