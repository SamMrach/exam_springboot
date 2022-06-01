package com.exam.models;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.persistence.Id;



@Entity
public class produit {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
	public String name;
	public String description;
	public float price;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
	private category categorie;
	
	@ManyToMany(mappedBy="Achats")
	private Collection<user> acheteurs;
	
	@ManyToMany(mappedBy="produits")
	private Collection<panier> paniers;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
}
