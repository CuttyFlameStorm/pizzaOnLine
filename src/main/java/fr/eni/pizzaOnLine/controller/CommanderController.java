package fr.eni.pizzaOnLine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.eni.pizzaOnLine.service.ProduitService;

@Controller
@RequestMapping("/commander")
public class CommanderController {

	@Autowired
	private ProduitService produitService;
	
	@GetMapping
	public String toutesLesCommandes(Model model) {
		
		// recuperer la liste de produits et le transmettre à la vue
				model.addAttribute("produits", produitService.consulterProduits());		
				return "commander";
	}
	
}
