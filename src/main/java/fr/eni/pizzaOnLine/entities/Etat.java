package fr.eni.pizzaOnLine.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Etat implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
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
