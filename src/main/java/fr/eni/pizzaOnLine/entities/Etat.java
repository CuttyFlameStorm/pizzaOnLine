package fr.eni.pizzaOnLine.entities;

import java.io.Serializable;

public class Etat implements Serializable{

	private Long id;
	private String libelle;
	
	
//	getters et setters 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
//	constructor avec et sans parametres
	public Etat() {
		super();
	}
	public Etat(Long id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}
	
	
	
	
}
