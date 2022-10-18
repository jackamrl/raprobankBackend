package com.mycompany.raprobank.repositories;

import com.mycompany.raprobank.entities.Societe;
import com.mycompany.raprobank.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SocieteRepo extends JpaRepository<Societe, Integer> {
    //To verifiy if this libelleSociete exist
    Boolean existsByLibelleSociete(String libelleSociete);
}
