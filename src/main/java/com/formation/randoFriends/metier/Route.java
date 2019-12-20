package com.formation.randoFriends.metier;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name="route")
public class Route {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private int id;
	
	private LocalDateTime dateDeCreation;
	private LocalDateTime  dateModification;
	private String nomCreateur;
	@ManyToOne @JsonIgnore private Trek trek;
	
	@OneToMany (mappedBy = "route") private Set<Location> locations;
	@OneToOne @JsonIgnore  private Image image;

	public Route(int id, LocalDateTime dateDeCreation, LocalDateTime dateModification, String nomCreateur) {
		super();
		this.id = id;
		this.dateDeCreation = dateDeCreation;
		this.dateModification = dateModification;
		this.nomCreateur = nomCreateur;
	}
	
	

}
