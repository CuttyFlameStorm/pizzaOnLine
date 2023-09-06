package fr.eni.pizzaOnLine.controller;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.eni.pizzaOnLine.dao.CommandeRepository;
import fr.eni.pizzaOnLine.dao.DetailCommandeRepository;
import fr.eni.pizzaOnLine.dao.EtatRepository;
import fr.eni.pizzaOnLine.dao.ProduitRepository;
import fr.eni.pizzaOnLine.entities.Commande;
import fr.eni.pizzaOnLine.entities.DetailCommande;
import fr.eni.pizzaOnLine.entities.Etat;
import fr.eni.pizzaOnLine.entities.Produit;

@Controller
@RequestMapping("/validation_paiement")
public class ValidationPaiementController {


	@Autowired
    private DetailCommandeRepository detailCommandeRepository;

    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    private EtatRepository etatRepository;

    @Autowired
    private CommandeRepository commandeRepository;
   
    

    
    @PostMapping
    public String validerCommande(Model model) {
List<DetailCommande> produitsDansPanier = detailCommandeRepository.findAll();
        
        // Calculez le montant total par itération sur le détails de la commande
        double montantTotal = produitsDansPanier.stream()
                .mapToDouble(detailCommande -> detailCommande.getProduit().getPrix())
                .sum();
        
        model.addAttribute("commandes", produitsDansPanier);
        model.addAttribute("montantTotal", montantTotal); // Ajoute du montant total de pizza au modèle
        
        
        // Une fois le traitement terminé, vous pouvez rediriger l'utilisateur vers une page de confirmation.
        return "validation_Paiement_pour_preparationPizza.html";
    }
    

    

    
    
    @PostMapping("/paiement")
    public String ConfirmationDePaiementEffectue() {
    	
    	return "confirmation_commande.html";
    }
	
	
}
