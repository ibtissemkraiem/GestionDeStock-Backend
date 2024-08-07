package com.example.angularsprinboot.models;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.beans.Transient;

@Data


public class ArticleRequest {
    private String designation;
    private String codeArticle;
    private float prixHT;

    private float prixTTC;

    private int tauxTVA;
    private Long idCategorie;
    // Nom de l'image du produit
    private String image;

    // Fichier image du produit (transient car non stocké en base de données)
   // @Transient
    private MultipartFile imageFile;
}
