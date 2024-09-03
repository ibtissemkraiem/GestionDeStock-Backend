package com.example.angularsprinboot.services;

import com.example.angularsprinboot.models.LigneCommande;

import java.util.List;
import java.util.Optional;

public interface LigneCommandeService {

    public List<LigneCommande> getAllCommandes();


    public Optional<LigneCommande> getLigneCommande(Long id);


    public LigneCommande createLigneCommande(LigneCommande ligneCommande);

    public LigneCommande UpdateLigneCommande(Long id ,LigneCommande ligneCommandeDetails);


    public void deleteLigneCommande(Long id);



}
