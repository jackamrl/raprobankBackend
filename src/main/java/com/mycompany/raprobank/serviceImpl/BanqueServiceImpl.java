package com.mycompany.raprobank.serviceImpl;

import com.mycompany.raprobank.entities.Banque;
import com.mycompany.raprobank.repositories.BanqueRepo;
import com.mycompany.raprobank.service.BanqueService;
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
public class BanqueServiceImpl implements BanqueService {

    private BanqueRepo banqueRepo;

    @Autowired
    public BanqueServiceImpl(BanqueRepo banqueRepo) {
        this.banqueRepo = banqueRepo;
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Override
    public Banque addBanque(Banque banque) {
//        banque.setIdBanque(UUID.randomUUID().variant());
        return banqueRepo.save(banque) ;
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Override
    public List<Banque> findAll() {
        return banqueRepo.findAll();
    }

    @Override
    public Banque findBanqueById(Integer idBanque) {
        return banqueRepo.findById(idBanque).orElseThrow(()-> new IllegalStateException("La banque"+idBanque+"n'existe pas"));
    }
}
