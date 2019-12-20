package com.formation.randoFriends.metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vividsolutions.jts.geom.Point;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name="locations")
public class Location {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int id;
															
	private int locations_order;
															
	private Point centre_geo;
	
	@ManyToOne	@JsonIgnore
	private Route route;
	
	public Location(int id, int locations_order, Point centre_geo) {
		super();
		this.id = id;
		this.locations_order = locations_order;
		this.centre_geo = centre_geo;
	}
	
	
	
											

}
