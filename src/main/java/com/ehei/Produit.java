package com.ehei;

public class Produit {
    private int id;
    private String nom;
    private double prix;
    private int quantite;
    
    public Produit(int id, String nom, double prix, int quantite) {
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
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}
	public double getPrix() {
		// TODO Auto-generated method stub
		return prix;
	}
	public int getQuantite() {
		// TODO Auto-generated method stub
		return quantite ;
	}
	public String getNom() {
		// TODO Auto-generated method stub
		return nom;
	}

}
