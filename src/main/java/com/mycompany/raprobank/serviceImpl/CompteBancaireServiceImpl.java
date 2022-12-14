package com.mycompany.raprobank.serviceImpl;

import com.mycompany.raprobank.entities.Banque;
import com.mycompany.raprobank.entities.CompteBancaire;
import com.mycompany.raprobank.entities.Societe;
import com.mycompany.raprobank.repositories.CompteBancaireRepo;
import com.mycompany.raprobank.service.BanqueService;
import com.mycompany.raprobank.service.CompteBancaireService;
import com.mycompany.raprobank.service.SocieteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Configuration
@EnableWebSecurity
@Service
public class CompteBancaireServiceImpl implements CompteBancaireService {

    public CompteBancaireRepo compteBancaireRepo;
    public BanqueService banqueService;
    public SocieteService societeService;

    @Autowired
    public CompteBancaireServiceImpl(CompteBancaireRepo compteBancaireRepo, BanqueService banqueService, SocieteService societeService) {
        this.compteBancaireRepo = compteBancaireRepo;
        this.banqueService = banqueService;
        this.societeService = societeService;

    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Override
    public CompteBancaire addCompteBancaire(CompteBancaire unCompteBancaire) {
        Banque banque = banqueService.findBanqueById(unCompteBancaire.getIdBanque());
        unCompteBancaire.setBanque(banque);
        Societe societe = societeService.findSocieteById(unCompteBancaire.getIdSociete());
        unCompteBancaire.setSociete(societe);
//        unCompteBancaire.setIdComptebancaire(UUID.randomUUID().variant());
        return compteBancaireRepo.save(unCompteBancaire);
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Override
    public List<CompteBancaire> findAll() {
        return compteBancaireRepo.findAll();
    }
}
