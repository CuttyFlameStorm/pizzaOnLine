package fr.eni.pizzaOnLine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.pizzaOnLine.dao.ProduitRepository;
import fr.eni.pizzaOnLine.entities.Produit;



@Service
public class ProduitServiceImpl implements ProduitService {

	@Autowired
	private ProduitRepository produitRepository;
	
	@Override
	public List<Produit> consulterProduits() {
		return produitRepository.findAll();
	}

	@Override
	public void sauvegarderProduit(Produit produit) {
		produitRepository.save(produit);
		
	}


	
	
}
