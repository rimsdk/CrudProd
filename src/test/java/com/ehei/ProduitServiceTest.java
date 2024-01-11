package com.ehei;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ProduitServiceTest {

    private ProduitService produitService;

    @Before
    public void setUp() {
        produitService = new ProduitService();
    }

    @Test
    public void testCreateProduit() {
        Produit produit1 = new Produit(101, "PC", 1700.0, 10);

        produitService.createProduit(produit1);
        List<Produit> produits = produitService.getProduits();

        assertEquals(1, produits.size());
        assertEquals(produit1, produits.get(0));
    }

    @Test
    public void testCreateProduitNonUnique() {
        Produit produit1 = new Produit(212, "Television", 3445.0, 8);
        Produit produit2 = new Produit(212, "iphone", 3039.0, 5);

        produitService.createProduit(produit1);
        produitService.createProduit(produit2);
        List<Produit> produits = produitService.getProduits();

        assertEquals(1, produits.size());
        assertEquals(produit1, produits.get(0));
    }

    @Test
    public void testSupprimerProduit() {
        Produit prod1 = new Produit(213, "tel", 2334.0, 433);

        produitService.createProduit(prod1);
        produitService.supprimerProduit(213);
        List<Produit> produits = produitService.getProduits();

        assertEquals(0, produits.size());
    }

    @Test
    public void testSupprimerProduitInexistant() {
        produitService.supprimerProduit(401); 
        List<Produit> produits = produitService.getProduits();

        assertEquals(0, produits.size());
    }

    @Test
    public void testLireProduitParId() {
        Produit produit1 = new Produit(543, "Camera", 300.0, 15);

        produitService.createProduit(produit1);
        Produit produitLu = produitService.lireProduitParId(501);

        assertNotNull(produitLu);
        assertEquals(produit1, produitLu);
    }

    @Test
    public void testLireProduitParIdInexistant() {
        Produit produitLu = produitService.lireProduitParId(601);

        assertNull(produitLu);
    }

    @Test
    public void testMettreAJourProduit() {
        Produit produit1 = new Produit(700, "PROD", 250.0, 12);
        produitService.createProduit(produit1);

        Produit produitMaj = new Produit(700, "PROD_MAJ", 300.0, 15);
        produitService.mettreAJourProduit(produitMaj);

        List<Produit> produits = produitService.getProduits();
        assertEquals("PROD_MAJ", produits.get(0).getNom());
    }

    @Test
    public void testMettreAJourProduitInexistant() {
        Produit produitMaj = new Produit(800, "PROD_MAJ", 100.0, 5);
        produitService.mettreAJourProduit(produitMaj); 

        List<Produit> produits = produitService.getProduits();
        assertEquals(0, produits.size());
    }
}
