package com.mycompany.raprobank.serviceImpl;

import com.mycompany.raprobank.entities.OperationGl;
import com.mycompany.raprobank.repositories.OperationGlRepo;
import com.mycompany.raprobank.services.OperationGlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

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
}
