package fr.eni.pizzaOnLine.entities;

import java.io.Serializable;

public class DetailCommande implements Serializable {

	private Integer quantite;

	
//	getters et setters 
	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	
//	constructor avec et sans parametres
	public DetailCommande() {
		super();
	}

	public DetailCommande(Integer quantite) {
		super();
		this.quantite = quantite;
	}
	
	
	
	
}
