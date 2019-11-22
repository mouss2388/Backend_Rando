package com.formation.randoFriends.metier;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name="users")
public class User {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int id;
	
	private String firstname;
	private String lastname;
	private Date birthday;
	

	public User(int id, String firstname, String lastname, Date birthday) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthday = birthday;
		
	}
	
	
	
	
	

}
