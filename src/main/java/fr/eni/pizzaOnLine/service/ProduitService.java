package fr.eni.pizzaOnLine.service;

import java.util.List;

import fr.eni.pizzaOnLine.entities.Produit;


public interface ProduitService {

	List<Produit> consulterProduits();
	void sauvegarderProduit(Produit produit);
	

	
}
