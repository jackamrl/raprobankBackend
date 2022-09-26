package com.mycompany.raprobank.serviceImpl;

import com.mycompany.raprobank.entities.OperationEb;
import com.mycompany.raprobank.repositories.OperationEbRepo;
import com.mycompany.raprobank.service.OperationEbService;
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
public class OperationEbServiceImpl implements OperationEbService {

    public OperationEbRepo operationEbRepo;

    @Autowired
    public OperationEbServiceImpl(OperationEbRepo operationEbRepo) {
        this.operationEbRepo = operationEbRepo;
    }
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Override
    public OperationEb addOperationEb(OperationEb operationEb) {
        operationEb.setIdOperation(UUID.randomUUID().variant());
        return operationEbRepo.save(operationEb);
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Override
    public List<OperationEb> findAll() {
        return operationEbRepo.findAll();
    }
}
