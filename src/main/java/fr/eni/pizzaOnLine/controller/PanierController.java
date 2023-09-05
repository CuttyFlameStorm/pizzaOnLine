package fr.eni.pizzaOnLine.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.eni.pizzaOnLine.dao.DetailCommandeRepository;
import fr.eni.pizzaOnLine.dao.ProduitRepository;
import fr.eni.pizzaOnLine.entities.DetailCommande;
import fr.eni.pizzaOnLine.entities.Produit;

@Controller
@RequestMapping("/panier")
public class PanierController {

    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private DetailCommandeRepository detailCommandeRepository;
    
    @GetMapping
    public String afficherPanier(Model model) {
        List<DetailCommande> produitsDansPanier = detailCommandeRepository.findAll();
        model.addAttribute("commandes", produitsDansPanier);
        return "panier";
    }

    @PostMapping("/ajouter")
    public String ajouterProduitAuPanier(@RequestParam("produitId") Long produitId) {
        Optional<Produit> produitOptional = produitRepository.findById(produitId);

        if (produitOptional.isPresent()) {
            Produit produit = produitOptional.get();
            DetailCommande detailCommande = new DetailCommande();
            detailCommande.setProduit(produit);
            detailCommandeRepository.save(detailCommande);
        } else {
            return "erreurpage";
        }

        return "redirect:/commander";
    }

    @PostMapping("/supprimerdupanier")
    public String supprimerProduitDuPanier(@RequestParam("commandeId") Long commandeId) {
        detailCommandeRepository.deleteById(commandeId);
        return "redirect:/panier";
    }
    
    
    
}
