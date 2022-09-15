package com.mycompany.raprobank.repositories;

import com.mycompany.raprobank.entities.Societe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocieteRepo extends JpaRepository<Societe, Integer> {
}
