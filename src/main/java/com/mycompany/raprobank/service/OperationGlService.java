package com.mycompany.raprobank.services;


import com.mycompany.raprobank.entities.OperationGl;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface OperationGlService {

    public OperationGl addOperationGl(OperationGl operationGl);
    public List<OperationGl> findAll();


}
