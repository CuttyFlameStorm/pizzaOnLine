package fr.eni.pizzaOnLine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.eni.pizzaOnLine.dao.CommandeRepository;
import fr.eni.pizzaOnLine.dao.DetailCommandeRepository;
import fr.eni.pizzaOnLine.dao.EtatRepository;
import fr.eni.pizzaOnLine.dao.ProduitRepository;
import fr.eni.pizzaOnLine.dao.RoleRepository;
import fr.eni.pizzaOnLine.dao.TypeProduitRepository;
import fr.eni.pizzaOnLine.dao.UtilisateurRepository;
import fr.eni.pizzaOnLine.entities.Role;
import fr.eni.pizzaOnLine.entities.TypeProduit;
import fr.eni.pizzaOnLine.entities.Utilisateur;


@Controller
@RequestMapping("/devadmin")
public class ADevController {

	
	@Autowired
	private CommandeRepository commandeRepository;
	@Autowired
	private DetailCommandeRepository detailCommandeRepository;
	@Autowired
	private EtatRepository etatRepository;
	@Autowired
	private ProduitRepository produitRepo;
	@Autowired
	private TypeProduitRepository typeProduitRepository;
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	

	
	@GetMapping
	public String gestionTypeProduit(Model model) {
//		model.addAttribute("produit", new Produit() );
		model.addAttribute("typeProduit", new TypeProduit());
		model.addAttribute("utilisateur", new Utilisateur());
		model.addAttribute("role", new Role());
//		model.addAttribute("etat", new Etat());
//		model.addAttribute("detailCommande", new DetailCommande());
//		model.addAttribute("commande", new Commande());
		List<Role> roles = roleRepository.findAll();
	    model.addAttribute("roles", roles);
		
		return "dev_back_office";
	}
	
	
	@PostMapping("/createTypeProduit")
	public String createTypeProduit(@ModelAttribute TypeProduit typeProduit) {
	    
		typeProduitRepository.save(typeProduit);
	    
	    return "redirect:/devadmin";
	}
	//--****---------------*****---------------******--------------
	@PostMapping("/createUtilisateur")
	public String createUtilisateur(@ModelAttribute Utilisateur utilisateur, @RequestParam("role") Long roleId, @RequestParam String motDePasse) {
	    // ...  
		// Encodez le mot de passe avec BCryptPasswordEncoder
	    String encodedPassword = passwordEncoder.encode(motDePasse);
	    utilisateur.setMotDePasse(encodedPassword);
		
		// Récupérez le rôle à partir de l'ID
	    Role role = roleRepository.findById(roleId).orElse(null);

	    if (role != null) {
	        // Associez le rôle à l'utilisateur
	        utilisateur.setRole(role);
	        
	        // Sauvegardez l'utilisateur avec le rôle
	        utilisateurRepository.save(utilisateur);
	    } else {
	        return "erreurpage";
	    }

	    return "redirect:/devadmin";
	}

	//--****---------------*****---------------******--------------
	@PostMapping("/createRole")
	public String createRole(@ModelAttribute Role role) {
	    
		roleRepository.save(role);
	    
	    return "redirect:/devadmin";
	}
	
}
