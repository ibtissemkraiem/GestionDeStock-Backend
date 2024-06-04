package com.example.angularsprinboot.controllers;
//CommandLineRunner tekhdem douba ma  nrunniw awel haja kima ngoninit fel angular

import com.example.angularsprinboot.Repositories.RoleRepository;
import com.example.angularsprinboot.models.ERole;
import com.example.angularsprinboot.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
//CommandLineRunner tekhdem douba ma  nrunniw awel haja kima ngoninit fel angular
@Component
public class RoleInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;
    @Autowired
    public RoleInitializer (RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        for (ERole roleName : ERole.values()) {
            if (!roleRepository.findByName(roleName).isPresent()) {
                roleRepository.save(new Role(roleName));
            }
        }
    }
}
