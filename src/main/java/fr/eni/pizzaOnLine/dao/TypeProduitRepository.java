package fr.eni.pizzaOnLine.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.pizzaOnLine.entities.TypeProduit;

public interface TypeProduitRepository extends JpaRepository<TypeProduit, Long>{

}
