package com.mycompany.raprobank.repositories;

import com.mycompany.raprobank.entities.CompteBancaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteBancaireRepo extends JpaRepository<CompteBancaire, Integer> {
}
