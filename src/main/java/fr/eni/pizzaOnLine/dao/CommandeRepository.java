package fr.eni.pizzaOnLine.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.pizzaOnLine.entities.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long>{

}
