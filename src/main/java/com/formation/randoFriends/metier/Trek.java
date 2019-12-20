package com.formation.randoFriends.metier;



import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name="treks")
public class Trek {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int id;
	
	
	
	private LocalDateTime dateDeCreation;
	
	private LocalDateTime dateDeroulement;
	private String description;
	private String nom;
	private String organisateur;
	
	@OneToMany (mappedBy = "trek")
	private Set<Route> routes;
	
	public Trek(int id, LocalDateTime dateDeCreation, LocalDateTime dateDeroulement, String description, String nom,
			String organisateur) {
		super();
		this.id = id;
		this.dateDeCreation = dateDeCreation;
		this.dateDeroulement = dateDeroulement;
		this.description = description;
		this.nom = nom;
		this.organisateur = organisateur;
		
		
	}
	
	
	@PrePersist
	public void beforeInsert() {
		this.dateDeCreation = LocalDateTime.now();
		this.dateDeroulement = dateDeroulement.now();
	}
	
	
	

}
