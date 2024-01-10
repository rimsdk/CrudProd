import java.util.ArrayList;
import java.util.List;

public class ProduitService {
    private List<Produit> produits;

    public ProduitService() {
        this.produits = new ArrayList<>();
    }

    // Création
    public void createProduit(Produit nouveauProduit) {
        if (!estUnique(nouveauProduit)) {
            System.out.println("Erreur : Un produit avec le même ID ou nom existe déjà.");
            return;
        }

        if (!sontDonneesValides(nouveauProduit)) {
            System.out.println("Erreur : Le prix et la quantité du produit doivent être positifs.");
            return;
        }

        produits.add(nouveauProduit);
    }
// Suppression
    public void supprimerProduit(Long id) {
        Produit produitASupprimer = lireProduitParId(id);
        if (produitASupprimer != null) {
            produits.remove(produitASupprimer);
        } else {
            System.out.println("Erreur : Produit non trouvé.");
        }
    }



       // Vérifier l'unicité
    private boolean estUnique(Produit produit) {
        return produits.stream().noneMatch(p -> p.getId().equals(produit.getId()) || p.getNom().equals(produit.getNom()));
    }

    // Vérifier la validité des données
    private boolean sontDonneesValides(Produit produit) {
        if (produit.getPrix() <= 0 || produit.getQuantite() <= 0) {
            return false;
        }
        return true;
    }
}