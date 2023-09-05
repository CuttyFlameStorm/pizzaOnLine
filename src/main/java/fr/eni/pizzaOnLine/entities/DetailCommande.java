package fr.eni.pizzaOnLine.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class DetailCommande implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private Long id;
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
