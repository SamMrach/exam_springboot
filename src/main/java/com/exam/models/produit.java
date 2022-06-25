package com.exam.models;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Id;


@JsonIgnoreProperties({  "commandes","paniers" })
@Entity
public class produit implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="produit_id")
	public Long id;
	public String name;
	public String description;
	public float price;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id",nullable=false)
	public category categorie;
	
	@Override
	public String toString() {
		return "produit [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", categorie=" + categorie + ", commandes=" + commandes + ", paniers=" + paniers + "]";
	}
	public category getCategorie() {
		return categorie;
	}
	public void setCategorie(category categorie) {
		this.categorie = categorie;
	}
	@OneToMany(mappedBy="produit")
	public Collection<commande> commandes;
	
	@OneToMany(mappedBy="produit")
	public Collection<panier> paniers;
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
