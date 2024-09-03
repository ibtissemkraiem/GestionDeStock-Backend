package com.example.angularsprinboot.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity

public class Commande {

  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCommande;

  private Date dateCommande;

  private String Status;

  private Double totalAmount;
  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user; // This is the client/user who made the commande

  @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<LigneCommande> ligneCommandes;










}
