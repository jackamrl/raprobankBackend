package com.mycompany.raprobank.service;
import com.mycompany.raprobank.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public List<User> findAll();
}
