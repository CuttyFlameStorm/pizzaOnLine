package fr.eni.pizzaOnLine.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.pizzaOnLine.entities.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long>{

	List<Commande> findByEtatLibelle(String libelle);
	
}
