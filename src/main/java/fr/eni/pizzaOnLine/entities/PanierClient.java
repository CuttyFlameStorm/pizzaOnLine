package fr.eni.pizzaOnLine.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor @AllArgsConstructor
@Entity
public class PanierClient implements Serializable{
	private static final long serialVersionUID = 1L;
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @OneToMany
    private List<DetailCommande> produitsDansPanier;

    private LocalDateTime dateCreation;

    private float montantTotal;

}
