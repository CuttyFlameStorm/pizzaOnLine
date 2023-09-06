package fr.eni.pizzaOnLine.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.pizzaOnLine.entities.Etat;

public interface EtatRepository extends JpaRepository<Etat, Long> {

	Etat findByLibelle(String libelle);
	
}
