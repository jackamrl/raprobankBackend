package com.mycompany.raprobank.repositories;

import java.util.Optional;

import com.mycompany.raprobank.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long>  {
        Optional<User> findByUsername(String username);

        Boolean existsByUsername(String username);

        Boolean existsByEmail(String email);
}
