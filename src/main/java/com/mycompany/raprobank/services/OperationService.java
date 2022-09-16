package com.mycompany.raprobank.services;

import com.mycompany.raprobank.entities.Operation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OperationService {
    public Operation addOperation(Operation operation);
    public List<Operation> findAll();

}
