package fr.eni.pizzaOnLine.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;


import fr.eni.pizzaOnLine.entities.Produit;


public interface ProduitRepository extends JpaRepository<Produit, Long>{

	public List<Produit> findByNom(String n);
	
}




