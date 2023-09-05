package fr.eni.pizzaOnLine.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class TypeProduit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
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
