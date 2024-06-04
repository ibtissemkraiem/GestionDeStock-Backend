package com.example.angularsprinboot.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategorie;


    private String Code_Categorie;
    private String Description_Categorie;


    /*@OneToMany(mappedBy = "categorie")
    private List<Article> articles;*/

}
