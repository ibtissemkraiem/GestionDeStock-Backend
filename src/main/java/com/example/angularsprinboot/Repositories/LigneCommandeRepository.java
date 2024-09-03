package com.example.angularsprinboot.Repositories;

import com.example.angularsprinboot.models.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneCommandeRepository extends JpaRepository<LigneCommande,Long> {
}
