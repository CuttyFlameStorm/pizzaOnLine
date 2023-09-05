package fr.eni.pizzaOnLine.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.pizzaOnLine.entities.DetailCommande;

public interface DetailCommandeRepository extends JpaRepository<DetailCommande, Long> {

}
