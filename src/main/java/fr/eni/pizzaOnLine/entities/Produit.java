package fr.eni.pizzaOnLine.entities;

import java.io.Serializable;

public class Produit implements Serializable {

	private Long id;
	private String nom;
	private String description;
	
	
//	getters et setters 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
//	constructor avec et sans parametres 
	public Produit() {
		super();
	}
	public Produit(Long id, String nom, String description) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
	}
	
	
	
	
	
}

