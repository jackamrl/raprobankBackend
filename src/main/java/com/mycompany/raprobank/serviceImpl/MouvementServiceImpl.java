package com.mycompany.raprobank.serviceImpl;

import com.mycompany.raprobank.entities.Mouvement;
import com.mycompany.raprobank.repositories.MouvementRepo;
import com.mycompany.raprobank.services.MouvementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class MouvementServiceImpl implements MouvementService {

    public MouvementRepo mouvementRepo;
    @Autowired
    public MouvementServiceImpl(MouvementRepo mouvementRepo) {
        this.mouvementRepo = mouvementRepo;
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Override
    public Mouvement addMouvement(Mouvement mouvement) {
        mouvement.setIdMouvement(UUID.randomUUID().variant());
        return mouvementRepo.save(mouvement);
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Override
    public List<Mouvement> findAll() {
        return mouvementRepo.findAll();
    }
}
