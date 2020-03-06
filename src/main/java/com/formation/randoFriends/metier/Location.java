package com.formation.randoFriends.metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vividsolutions.jts.geom.Geometry;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name="locations")
public class Location {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int id;
															
	private Geometry centre_geo;
	
	@ManyToOne	@JsonIgnore
	private Route route;

	public Location(int id, Geometry centre_geo, Route route) {
		this.id = id;
		this.centre_geo = centre_geo;
		this.route = route;
	}
	
	
	
	
											

}
