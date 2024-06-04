package com.example.angularsprinboot.services;

import com.example.angularsprinboot.models.Categorie;

import java.util.List;

public interface CategorieService {

    public Categorie addCategory(Categorie categorie);


    public List<Categorie> getAllCategorie();
}
