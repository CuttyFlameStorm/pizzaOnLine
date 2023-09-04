package fr.eni.pizzaOnLine.entities;

import java.io.Serializable;

public class TypeProduit implements Serializable {

	private Integer id;
	private String libelle;
	
	
//	getters et setters 
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
	
//	constructor avec et sans parametre
	public TypeProduit() {
		super();
	}
	public TypeProduit(Integer id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}
	
	
	
	
	
}
