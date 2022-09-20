package com.mycompany.raprobank.repositories;

import com.mycompany.raprobank.entities.Operation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface OperationBaseRepository<T extends Operation> extends CrudRepository<T, Integer> {
}
