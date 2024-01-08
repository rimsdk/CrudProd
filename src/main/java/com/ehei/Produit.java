package com.ehei;

public class Produit {
    private Long id;
    private String nom;
    private double prix;
    private int quantite;
    
    public Produit(Long id, String nom, double prix, int quantite) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;
    }
    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                ", quantite=" + quantite +
                '}';
    }

}
