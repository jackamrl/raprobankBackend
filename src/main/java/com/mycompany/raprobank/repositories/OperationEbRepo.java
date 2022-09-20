package com.mycompany.raprobank.repositories;

import com.mycompany.raprobank.entities.OperationEb;
import com.mycompany.raprobank.entities.OperationGl;
import com.mycompany.raprobank.services.OperationEbService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationEbRepo extends OperationRepo<OperationEb> {
}
