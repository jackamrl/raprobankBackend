package com.mycompany.raprobank.repositories;

import com.mycompany.raprobank.entities.Operation;
import com.mycompany.raprobank.entities.OperationGl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationGlRepo extends OperationBaseRepository<OperationGl> {
}
