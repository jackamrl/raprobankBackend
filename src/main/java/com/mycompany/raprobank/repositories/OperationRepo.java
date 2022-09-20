package com.mycompany.raprobank.repositories;

import com.mycompany.raprobank.entities.Operation;
import com.mycompany.raprobank.entities.OperationEb;
import com.mycompany.raprobank.entities.OperationGl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface OperationRepo<T extends Operation> extends JpaRepository<T, Integer> {

    @Query("from OperationGl")
    List<OperationGl> findAllOprationGl();

    @Query("from OperationEb")
    List<OperationEb> findAllOprationEb();
}
