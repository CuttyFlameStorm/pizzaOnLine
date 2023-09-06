package fr.eni.pizzaOnLine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.eni.pizzaOnLine.dao.TypeProduitRepository;
import fr.eni.pizzaOnLine.entities.TypeProduit;


@Controller
@RequestMapping("/devadmin")
public class ADevController {

	
//	@Autowired
//	private CommandeRepository commandeRepository;
//	@Autowired
//	private DetailCommandeRepository detailCommandeRepository;
//	@Autowired
//	private EtatRepository etatRepository;
//	@Autowired
//	private ProduitRepository produitRepo;
	@Autowired
	private TypeProduitRepository typeProduitRepository;
	

	
	@GetMapping
	public String gestionTypeProduit(Model model) {
//		model.addAttribute("produit", new Produit() );
		model.addAttribute("typeProduit", new TypeProduit());
//		model.addAttribute("etat", new Etat());
//		model.addAttribute("detailCommande", new DetailCommande());
//		model.addAttribute("commande", new Commande());
		return "dev_back_office";
	}
	
	
	@PostMapping("/createTypeProduit")
	public String createTypeProduit(@ModelAttribute TypeProduit typeProduit) {
	    
		typeProduitRepository.save(typeProduit);
	    
	    return "redirect:/devadmin";
	}
	
}