package com.example.angularsprinboot.services;

import com.example.angularsprinboot.Repositories.LigneCommandeRepository;
import com.example.angularsprinboot.models.LigneCommande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LigneCommandeServiceImpl implements LigneCommandeService{


    @Autowired
    LigneCommandeRepository ligneCommandeRepository;


    @Override
    public List<LigneCommande> getAllCommandes() {
        return ligneCommandeRepository.findAll();
    }

    @Override
    public Optional<LigneCommande> getLigneCommande(Long id) {
        return ligneCommandeRepository.findById(id);
    }

    @Override
    public LigneCommande createLigneCommande(LigneCommande ligneCommande) {
        return ligneCommandeRepository.save(ligneCommande);
    }

    @Override
    public LigneCommande UpdateLigneCommande(Long id, LigneCommande ligneCommandeDetails) {
        Optional<LigneCommande> optionalLigneCommande = ligneCommandeRepository.findById(id);

        if (!optionalLigneCommande.isPresent()) {
            // Handle the case where the LigneCommande is not found, e.g., returning null or throwing a runtime exception
            throw new RuntimeException("LigneCommande not found with id " + id);
        }

        LigneCommande existingLigneCommande = optionalLigneCommande.get();
        existingLigneCommande.setArticle(ligneCommandeDetails.getArticle());
       // existingLigneCommande.setArticle(ligneCommandeDetails.getQuantity());
        existingLigneCommande.setPrice(ligneCommandeDetails.getPrice());

        return ligneCommandeRepository.save(existingLigneCommande);
    }

    @Override
    public void deleteLigneCommande(Long id) {

    }


    /*@Override
    public void deleteLigneCommande(Long id) {
        LigneCommande ligneCommande = getLigneCommande(id);


    }*/
}
