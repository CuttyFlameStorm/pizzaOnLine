package fr.eni.pizzaOnLine.controller;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.eni.pizzaOnLine.dao.ProduitRepository;
import fr.eni.pizzaOnLine.dao.TypeProduitRepository;
import fr.eni.pizzaOnLine.entities.Produit;
import fr.eni.pizzaOnLine.service.ProduitService;



@Controller
@RequestMapping("/carte")
public class AdminController {


	@Autowired
	private ProduitService produitService;
	@Autowired
	private ProduitRepository produitRepo;
	@Autowired
	private TypeProduitRepository typeProduitRepo;
	
	private String Messagesaved = "produit ajouté avec succès";
	 @ModelAttribute("Messagesaved")
	    public String getMessagesaved() {
	        return Messagesaved;
	    }

	
	@GetMapping
	public String ajotuerPizzaForm(Model model) {
		model.addAttribute("produit", new Produit() );
		model.addAttribute("produits", produitRepo.findAll());	
		return "carte";
	}

	@PostMapping("/ajouterPizza")
	public String ajouterTraitement(
	        @ModelAttribute Produit produit,
	        Model model) {
		
//		produitService.sauvegarderProduit(produit);
		produitRepo.save(produit);
		model.addAttribute("Messagesaved", getMessagesaved() );
		model.addAttribute("produit", new Produit() );
		return "redirect:/carte";
	}
	

	
	@PostMapping("/supprimerpizza")
	public String supprimerPizza(@RequestParam("id") Long id, Model model) {
	    produitRepo.deleteById(id);
	    model.addAttribute("Messagesaved", getMessagesaved());
	    return "redirect:/carte";
	}
	
	@GetMapping("/modifierpizza")
    public String modifierPizzaForm(@RequestParam("id") Long id, Model model) {
        Optional<Produit> produitOptional = produitRepo.findById(id);
        if (produitOptional.isPresent()) {
            Produit produit = produitOptional.get();
            model.addAttribute("produit", produit);
            return "modifierPizza"; //  page Thymeleaf pour la modification (modifierPizza.html)
        } else {
            return "redirect:/carte";
        }
    }
	

    @PostMapping("/modifierpizzapost")
    public String modifierPizza(@ModelAttribute Produit produit, Model model) {
        produitRepo.save(produit);
        model.addAttribute("Messagesaved", getMessagesaved());
        return "redirect:/carte";
    }
	
    
	
    
    
    
	
}
