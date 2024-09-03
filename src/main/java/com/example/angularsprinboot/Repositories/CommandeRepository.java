package com.example.angularsprinboot.Repositories;

import com.example.angularsprinboot.models.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande,Long> {
}
