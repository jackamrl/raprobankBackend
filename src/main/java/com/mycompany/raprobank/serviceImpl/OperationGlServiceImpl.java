package com.mycompany.raprobank.serviceImpl;

import com.mycompany.raprobank.entities.OperationGl;
import com.mycompany.raprobank.repositories.OperationGlRepo;
import com.mycompany.raprobank.service.OperationGlService;
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

public class OperationGlServiceImpl implements OperationGlService {

    private OperationGlRepo operationGlRepo;

    @Autowired
    public OperationGlServiceImpl(OperationGlRepo operationGlRepo) {
        this.operationGlRepo = operationGlRepo;
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Override
    public OperationGl addOperationGl(OperationGl operationGl) {
        operationGl.setIdOperation(UUID.randomUUID().variant());
        return operationGlRepo.save(operationGl);
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Override
    public List<OperationGl> findAll() {
        return (List<OperationGl>) operationGlRepo.findAll();
    }
}
