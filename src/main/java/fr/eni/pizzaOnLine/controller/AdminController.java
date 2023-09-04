package fr.eni.pizzaOnLine.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import fr.eni.pizzaOnLine.entities.Produit;
import fr.eni.pizzaOnLine.service.ProduitService;



@Controller
@RequestMapping("/carte")
public class AdminController {


	@Autowired
	private ProduitService produitService;
	
	private String Messagesaved = "produit ajouté avec succès";
	 @ModelAttribute("Messagesaved")
	    public String getMessagesaved() {
	        return Messagesaved;
	    }

	
	@GetMapping
	public String ajotuerPizzaForm(Model model) {
		model.addAttribute("produit", new Produit() );
		return "carte";
	}
	
	
	
	@PostMapping("/ajouterPizza")
	public String ajouterTraitement(
	        @ModelAttribute Produit produit,
	        Model model) {
		
		produitService.sauvegarderProduit(produit);
		model.addAttribute("Messagesaved", getMessagesaved() );
		model.addAttribute("produit", new Produit() );
		return "redirect:/carte";
	}
	
	
}
