package com.mycompany.raprobank.services;


import com.mycompany.raprobank.entities.Banque;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BanqueService {

    public Banque addBanque(Banque banque);
    public List<Banque> findAll();

}
