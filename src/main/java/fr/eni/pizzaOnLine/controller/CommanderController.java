package fr.eni.pizzaOnLine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.eni.pizzaOnLine.dao.DetailCommandeRepository;
import fr.eni.pizzaOnLine.dao.ProduitRepository;
import fr.eni.pizzaOnLine.entities.DetailCommande;
import fr.eni.pizzaOnLine.service.ProduitService;

@Controller
@RequestMapping("/commander")
public class CommanderController {

	@Autowired
	private ProduitService produitService;
    @Autowired
    private DetailCommandeRepository detailCommandeRepository;
	
	@GetMapping
	public String toutesLesProduits(Model model) {
		
		
		List<DetailCommande> produitsDansPanier = detailCommandeRepository.findAll();
		if (produitsDansPanier.size()<1) {
			int quantiteDansPanier = 0;
			model.addAttribute("quantiteDansPanier", quantiteDansPanier); // Ajoutez la quantité au modèle
			model.addAttribute("produits", produitService.consulterProduits());	// recuperer la liste de produits et le transmettre à la vue
			
			return "commander";
		} else {
			int quantiteDansPanier = produitsDansPanier.size(); 
			model.addAttribute("quantiteDansPanier", quantiteDansPanier); 
			model.addAttribute("produits", produitService.consulterProduits());	
			
			return "commander";
		}

	}
	
	
	
}
