package com.example.angularsprinboot.models;


import jakarta.persistence.*;
import lombok.Data;


// taawedh everything
@Data
@Entity
public class Article {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private  Long idArticle;

    private String designation;
private String codeArticle;
    private float prixHT;

   private float prixTTC;

    private int tauxTVA;

    @ManyToOne
    @JoinColumn(name = "id_category")

    private Categorie categorie;


}
