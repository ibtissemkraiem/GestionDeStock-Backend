package com.example.angularsprinboot.Repositories;

import com.example.angularsprinboot.models.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Categorie,Long>{

}
