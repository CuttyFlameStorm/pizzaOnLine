package fr.eni.pizzaOnLine.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import fr.eni.pizzaOnLine.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	
	Role findByLibelle(String libelle);
	
}
