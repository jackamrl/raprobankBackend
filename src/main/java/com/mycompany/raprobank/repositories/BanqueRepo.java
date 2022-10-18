package com.mycompany.raprobank.repositories;

import com.mycompany.raprobank.entities.Banque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BanqueRepo extends JpaRepository<Banque, Integer> {
    //To verifiy if this libelleBanque exist
    Boolean existsByLibelleBanque(String libelleBanque);
}
