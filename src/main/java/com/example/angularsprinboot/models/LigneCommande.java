package com.example.angularsprinboot.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class LigneCommande {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "commande_id", nullable = false)
    private Commande commande;

    @ManyToOne
    @JoinColumn(name = "article_id", nullable = false)
    private Article article;
    private Double price;





}
