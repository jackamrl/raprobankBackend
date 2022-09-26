package com.mycompany.raprobank.serviceImpl;

import com.mycompany.raprobank.entities.Operation;
import com.mycompany.raprobank.entities.OperationEb;
import com.mycompany.raprobank.entities.OperationGl;
import com.mycompany.raprobank.repositories.OperationRepo;
import com.mycompany.raprobank.service.OperationService;
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
public class OperationServiceImpl implements OperationService {

    private OperationRepo<Operation> operationRepo;
    private OperationRepo<OperationGl> operationGlRepo;
    private OperationRepo<OperationEb> operationEbRepo;

    @Autowired
    public OperationServiceImpl(OperationRepo<Operation> operationRepo, OperationRepo<OperationGl> operationGlRepo, OperationRepo<OperationEb> operationEbRepo) {
        this.operationRepo = operationRepo;
        this.operationGlRepo = operationGlRepo;
        this.operationEbRepo = operationEbRepo;
    }


    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Override
    public Operation addOperation(Operation operation) {
        operation.setIdOperation(UUID.randomUUID().variant());
        return (Operation) operationRepo.save(operation);
    }

    @Override
    public OperationEb addOperationEb(OperationEb operationEb) {
        operationEb.setIdOperation(UUID.randomUUID().variant());
        return operationEbRepo.save(operationEb);
    }

    @Override
    public OperationGl addOperationGl(OperationGl operationGl) {
        operationGl.setIdOperation(UUID.randomUUID().variant());
        return operationGlRepo.save(operationGl);
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Override
    public List<Operation> findAll() {
        return operationRepo.findAll();
    }

    @Override
    public List<OperationEb> findOperationEb() {
        return operationEbRepo.findAllOprationEb();
    }

    @Override
    public List<OperationGl> findOperationGl() {
        return operationGlRepo.findAllOprationGl();
    }
}
