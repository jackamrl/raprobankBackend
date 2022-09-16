package com.mycompany.raprobank.repositories;

import com.mycompany.raprobank.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationRepo extends JpaRepository<Operation, Integer> {
}
