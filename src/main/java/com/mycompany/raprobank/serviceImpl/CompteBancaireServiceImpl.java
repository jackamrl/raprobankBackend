package com.mycompany.raprobank.serviceImpl;

import com.mycompany.raprobank.entities.CompteBancaire;
import com.mycompany.raprobank.repositories.CompteBancaireRepo;
import com.mycompany.raprobank.services.CompteBancaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class CompteBancaireServiceImpl implements CompteBancaireService {

    public CompteBancaireRepo compteBancaireRepo;

    @Autowired
    public CompteBancaireServiceImpl(CompteBancaireRepo compteBancaireRepo) {
        this.compteBancaireRepo = compteBancaireRepo;
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Override
    public CompteBancaire addCompteBancaire(CompteBancaire unCompteBancaire) {
        unCompteBancaire.setIdComptebancaire(UUID.randomUUID().variant());
        return compteBancaireRepo.save(unCompteBancaire);
    }
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Override
    public List<CompteBancaire> findAll() {
        return compteBancaireRepo.findAll();
    }
}
