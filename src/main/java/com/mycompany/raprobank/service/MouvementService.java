package com.mycompany.raprobank.service;

import com.mycompany.raprobank.entities.Mouvement;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MouvementService {
    public Mouvement addMouvement(Mouvement mouvement);
    public List<Mouvement> findAll();

}
