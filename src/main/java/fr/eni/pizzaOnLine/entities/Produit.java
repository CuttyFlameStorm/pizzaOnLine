package fr.eni.pizzaOnLine.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Produit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private Long id;
	private String nom;
	private String description;
	private Float prix;
	private String urlimage;
	
	
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
	
	
	
public Float getPrix() {
		return prix;
	}
	public void setPrix(Float prix) {
		this.prix = prix;
	}
	public String getUrlimage() {
		return urlimage;
	}
	public void setUrlimage(String urlimage) {
		this.urlimage = urlimage;
	}
	//	constructor avec et sans parametres 
	public Produit() {
		super();
	}
	public Produit(Long id, String nom, String description, Float prix, String urlimage) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.urlimage = urlimage;
	}
	
	

	
	
	
	
	
}

