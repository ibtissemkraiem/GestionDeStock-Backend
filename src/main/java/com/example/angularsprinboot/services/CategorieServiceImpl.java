package com.example.angularsprinboot.services;

import com.example.angularsprinboot.Repositories.CategoryRepository;
import com.example.angularsprinboot.models.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategorieServiceImpl implements CategorieService{
    @Autowired
    CategoryRepository categoryRepository;




    @Override
    public Categorie addCategory(Categorie categorie) {
        return categoryRepository.save(categorie);
    }




    @Override
    public java.util.List<Categorie> getAllCategorie() {
        return categoryRepository.findAll();
    }
}
