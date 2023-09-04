package fr.eni.pizzaOnLine;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


import fr.eni.pizzaOnLine.dao.ProduitRepository;
import fr.eni.pizzaOnLine.entities.Produit;


@SpringBootApplication
public class PizzaOnLineApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(PizzaOnLineApplication.class, args);
		ProduitRepository produitRepository = ctx.getBean(ProduitRepository.class);
		

		
		
		for (int i = 1; i < 18; i++) {
		    Produit produit = new Produit();
		    
		    produit.setNom("pizzaName:" + i);
		    produit.setDescription("pizzadescription" + i);
		    produitRepository.save(produit);
		}
		
	}

}
