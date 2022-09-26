package com.mycompany.raprobank.service;

import com.mycompany.raprobank.entities.CompteBancaire;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompteBancaireService {
    public CompteBancaire addCompteBancaire(CompteBancaire unCompteBancaire);
    public List<CompteBancaire> findAll();
}
