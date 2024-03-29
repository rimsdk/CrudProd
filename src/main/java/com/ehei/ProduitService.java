package com.ehei;
import java.util.ArrayList;
import java.util.List;

public class ProduitService {
    private List<Produit> produits;

    public ProduitService() {
        this.produits = new ArrayList<>();
    }


    public void createProduit(Produit PROD) {
        if (!estUnique(PROD)) {
            System.out.println("produit deja existe.");
            return;
        }

        if (!sontDonneesValides(PROD)) {
            System.out.println("donnes non valides");
            return;
        }

        produits.add(PROD);
    }

    public void supprimerProduit(int id) {
        Produit produitASupprimer = lireProduitParId(id);
        if (produitASupprimer != null) {
            produits.remove(produitASupprimer);
        } else {
            System.out.println("Produit inexistant.");
        }
    }

    public Produit lireProduitParId(int id) {
        for (Produit produit : produits) {
            if (produit.getId() == id) {
                return produit;
            }
        }
        System.out.println("Produit inexistan.");
        return null;
    }

  
    public void mettreAJourProduit(Produit PROD) {
        if (!produits.contains(PROD)) {
            System.out.println("Erreur : Le produit à mettre à jour n'existe pas.");
            return;
        }

        if (!estUnique(PROD)) {
            System.out.println("Erreur : Un autre produit avec le même ID ou nom existe déjà.");
            return;
        }

        if (!sontDonneesValides(PROD)) {
            System.out.println("Erreur : Le prix et la quantité du produit doivent être positifs.");
            return;
        }

        int index = produits.indexOf(PROD);
        produits.set(index, PROD);
    }


    private boolean estUnique(Produit produit) {
        return produits.stream().noneMatch(p -> p.getId() == produit.getId() || p.getNom().equals(produit.getNom()));
    }



    private boolean sontDonneesValides(Produit produit) {
        if (produit.getPrix() <= 0 || produit.getQuantite() <= 0) {
            return false;
        }
        return true;
    }

    public List<Produit> getProduits() {
        return produits;
    }
}