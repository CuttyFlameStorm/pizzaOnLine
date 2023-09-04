package fr.eni.pizzaOnLine.entities;

import java.io.Serializable;
import java.util.Date;

public class Commande implements Serializable {
	
	private Long id;
	private Date dateHeureLivraison;
	private Date dateHeurePreparation;
	
	
//	getters et setters 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDateHeureLivraison() {
		return dateHeureLivraison;
	}
	public void setDateHeureLivraison(Date dateHeureLivraison) {
		this.dateHeureLivraison = dateHeureLivraison;
	}
	public Date getDateHeurePreparation() {
		return dateHeurePreparation;
	}
	public void setDateHeurePreparation(Date dateHeurePreparation) {
		this.dateHeurePreparation = dateHeurePreparation;
	}
	
//	Constructor avec et sans parametre
	public Commande() {
		super();
	}
	public Commande(Long id, Date dateHeureLivraison, Date dateHeurePreparation) {
		super();
		this.id = id;
		this.dateHeureLivraison = dateHeureLivraison;
		this.dateHeurePreparation = dateHeurePreparation;
	}
	
	
	
	
}

