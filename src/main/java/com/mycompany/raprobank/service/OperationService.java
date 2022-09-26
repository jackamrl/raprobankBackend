package com.mycompany.raprobank.service;

import com.mycompany.raprobank.entities.Operation;
import com.mycompany.raprobank.entities.OperationEb;
import com.mycompany.raprobank.entities.OperationGl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OperationService {
    public Operation addOperation(Operation operation);
    public OperationEb addOperationEb(OperationEb operationEb);
    public OperationGl addOperationGl(OperationGl operationGl);
    public List<Operation> findAll();

    public List<OperationEb> findOperationEb();
    public List<OperationGl> findOperationGl();



}
