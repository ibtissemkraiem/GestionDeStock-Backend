package com.example.angularsprinboot.Repositories;

import com.example.angularsprinboot.models.ERole;
import com.example.angularsprinboot.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;



@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}