package com.mycompany.raprobank.repositories;

import com.mycompany.raprobank.entities.Mouvement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MouvementRepo extends JpaRepository<Mouvement, Integer> {
}
