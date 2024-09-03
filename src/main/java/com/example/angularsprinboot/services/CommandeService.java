package com.example.angularsprinboot.services;

import com.example.angularsprinboot.models.Commande;

import java.util.List;
import java.util.Optional;

public interface CommandeService {

    public List<Commande> getAllCommandes();

    public Optional<Commande> getCommandeById(Long id);

    public Commande createCommande(Commande commande);

    public void deleteCommande(Long id);

   public Commande updateCommande(Long id, Commande commandeDetails);



}
