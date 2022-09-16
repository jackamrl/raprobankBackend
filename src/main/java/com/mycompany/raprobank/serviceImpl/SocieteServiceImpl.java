package com.mycompany.raprobank.serviceImpl;

import com.mycompany.raprobank.entities.Societe;
import com.mycompany.raprobank.repositories.SocieteRepo;
import com.mycompany.raprobank.services.SocieteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.UUID;

@Service
public class SocieteServiceImpl implements SocieteService {

    public SocieteRepo societeRepo;

    @Autowired
    public SocieteServiceImpl(SocieteRepo societeRepo) {
        this.societeRepo = societeRepo;
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Override
    public Societe addSociete(Societe societe) {
        societe.setIdSociete(UUID.randomUUID().variant());
        return societeRepo.save(societe);
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Override
    public List<Societe> findAll() {
        return societeRepo.findAll();
    }
}