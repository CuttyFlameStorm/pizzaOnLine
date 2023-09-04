package fr.eni.pizzaOnLine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/panier")
public class PanierController {

	@GetMapping
	public String tousLePanier() {
		
		
		return "panier";
	}
	
}
