package fr.eni.pizzaOnLine.controller;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.eni.pizzaOnLine.dao.CommandeRepository;
import fr.eni.pizzaOnLine.dao.DetailCommandeRepository;
import fr.eni.pizzaOnLine.dao.EtatRepository;
import fr.eni.pizzaOnLine.entities.Commande;
import fr.eni.pizzaOnLine.entities.DetailCommande;
import fr.eni.pizzaOnLine.entities.Etat;

@Controller
@RequestMapping("/validation_paiement")
public class ValidationPaiementController {


	@Autowired
    private DetailCommandeRepository detailCommandeRepository;


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
        
        float montantTotalParse = (float)montantTotal;
        
        model.addAttribute("commandes", produitsDansPanier);
        model.addAttribute("montantTotal", montantTotalParse); // Ajoute du montant total de pizza au modèle
        
        
        // Une fois le traitement terminé, vous pouvez rediriger l'utilisateur vers une page de confirmation.
        return "validation_Paiement_pour_preparationPizza.html";
    }
    

    
    @PostMapping("/paiement")
    public String ConfirmationDePaiementEffectue(Model model) {
        // Créez une nouvelle commande
        Commande nouvelleCommande = new Commande();

        // Créez la Date dateHeurePreparation
        LocalDateTime dateHeurePreparation = LocalDateTime.now();

        // Calculez la Date dateHeureLivraison = dateHeurePreparation + 45 minutes
        LocalDateTime dateHeureLivraison = dateHeurePreparation.plus(45, ChronoUnit.MINUTES);

        // Créez un nouvel état avec le libellé "enPreparation"
        Etat nouvelEtat = new Etat();
        nouvelEtat.setLibelle("enPreparation");

       
        etatRepository.save(nouvelEtat);

        // Associez la date de préparation et l'état à la commande
        nouvelleCommande.setDateHeurePreparation(dateHeurePreparation);
        nouvelleCommande.setDateHeureLivraison(dateHeureLivraison);
        nouvelleCommande.setEtat(nouvelEtat);

        
        commandeRepository.save(nouvelleCommande);

        model.addAttribute("heureLivraison", dateHeureLivraison);
        
        return "confirmation_commande.html";
    }
    
///////////////////////partie preparation des pizza ///////////////////////////////////////////
    
    
    @GetMapping("/commandes/enPreparation")
    public String afficherCommandesEnPreparation(Model model) {
        List<Commande> commandesEnPreparation = commandeRepository.findByEtatLibelle("enPreparation");
        model.addAttribute("commandes", commandesEnPreparation);
        return "preparation"; // vue qui va gérer les pizzas en préparation
    }
    
    
	
	
}
