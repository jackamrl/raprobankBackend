package com.mycompany.raprobank.service;

import com.mycompany.raprobank.entities.Societe;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SocieteService {

    public Societe addSociete(Societe societe);
    public List<Societe> findAll();
    public Societe findSocieteById(Integer idSociete);

}
