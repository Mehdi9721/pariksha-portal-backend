package com.example.demo;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.demo.Models.AdminsDataModel;
import com.example.demo.jpaRepositories.AdminsDataRepository;

@Component
public class DatabaseInitializer implements ApplicationRunner {

    @Autowired
    private AdminsDataRepository adminRepo; 
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) throws Exception {
      
   
    }
}
