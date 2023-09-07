package fr.eni.pizzaOnLine.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.pizzaOnLine.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{

	
	
}
