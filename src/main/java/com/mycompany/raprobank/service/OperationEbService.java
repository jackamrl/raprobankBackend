package com.mycompany.raprobank.service;

import com.mycompany.raprobank.entities.OperationEb;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OperationEbService {
    public OperationEb addOperationEb(OperationEb operationEb);
    public List<OperationEb> findAll();

}
