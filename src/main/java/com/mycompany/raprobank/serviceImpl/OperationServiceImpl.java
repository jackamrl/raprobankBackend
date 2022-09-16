package com.mycompany.raprobank.serviceImpl;

import com.mycompany.raprobank.entities.Operation;
import com.mycompany.raprobank.repositories.OperationRepo;
import com.mycompany.raprobank.services.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class OperationServiceImpl implements OperationService {

    public OperationRepo operationRepo;

    @Autowired
    public OperationServiceImpl(OperationRepo operationRepo) {
        this.operationRepo = operationRepo;
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Override
    public Operation addOperation(Operation operation) {
        operation.setIdOperation(UUID.randomUUID().variant());
        return operationRepo.save(operation);
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Override
    public List<Operation> findAll() {
        return operationRepo.findAll();
    }
}
