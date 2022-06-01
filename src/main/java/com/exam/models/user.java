package com.exam.models;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import javax.persistence.Id;






@Entity
public class user {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long id;
	public String name;
	public String email;
	public String password;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "commandes",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = @JoinColumn(name = "produit_id")
    )
	private Collection<produit> Achats;
	 @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "panier_id")
	private panier panier;
	
	
	 public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}