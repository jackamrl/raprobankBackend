package com.mycompany.raprobank.serviceImpl;

import com.mycompany.raprobank.entities.Societe;
import com.mycompany.raprobank.repositories.SocieteRepo;
import com.mycompany.raprobank.service.SocieteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.UUID;

@Configuration
@EnableWebSecurity
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
        //societe.setIdSociete(UUID.randomUUID().variant());
        return societeRepo.save(societe);
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Override
    public List<Societe> findAll() {
        return societeRepo.findAll();
    }

    @Override
    public Societe findSocieteById(Integer idSociete) {
        return societeRepo.findById(idSociete).orElseThrow(()-> new IllegalStateException("La societe"+idSociete+"n'existe pas"));
    }
}
