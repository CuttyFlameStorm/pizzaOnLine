package fr.eni.pizzaOnLine.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/carte")
public class HomeController {

	@GetMapping
	public String tousLesProduits() {
		
		
		return "carte";
	}
	
	
}
