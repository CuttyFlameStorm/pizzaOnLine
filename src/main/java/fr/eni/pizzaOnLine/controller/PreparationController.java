package fr.eni.pizzaOnLine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/preparation")
public class PreparationController {

	@GetMapping
	public String enPreparation() {
		
		
		return "preparation";
	}
	
}
