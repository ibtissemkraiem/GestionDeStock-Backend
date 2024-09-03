package com.example.angularsprinboot.services;

import com.example.angularsprinboot.Repositories.CommandeRepository;
import com.example.angularsprinboot.models.Commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommandeServiceImpl implements CommandeService{




    @Autowired
    CommandeRepository commandeRepository;

    @Override
    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    @Override
    public Optional<Commande> getCommandeById(Long id) {
        return commandeRepository.findById(id);
    }


    @Override
    public Commande createCommande(Commande commande) {

        return commandeRepository.save(commande);
    }

    @Override
    public void deleteCommande(Long id) {

    }

    @Override
    public Commande updateCommande(Long id, Commande commandeDetails) {
        return null;
    }

   /* @Override
    public void deleteCommande(Long id) {
        Commande commande = getCommandeById(id);
        commandeRepository.delete(commande);

    }

    @Override
    public Commande updateCommande(Long id, Commande commandeDetails) {
        Commande commande = getCommandeById(id);
        return commandeRepository.save(commande);
    }
*/



}
