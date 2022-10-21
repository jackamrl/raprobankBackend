package com.mycompany.raprobank.serviceImpl;

import com.mycompany.raprobank.entities.User;
import com.mycompany.raprobank.repositories.UserRepo;
import com.mycompany.raprobank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Configuration
@EnableWebSecurity
@Service
public class UserServiceImpl implements UserService {

    public UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }
}
