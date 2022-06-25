package com.exam.models;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.JoinColumn;

import javax.persistence.Id;

@JsonIgnoreProperties({})
@Entity
public class panier implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int quantity;
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@ManyToOne()
	@JoinColumn(name="produit_id",nullable=false)
	public produit produit;
	public produit getProduit() {
		return produit;
	}

	public void setProduit(produit produit) {
		this.produit = produit;
	}

	public panier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@ManyToOne()
	@JoinColumn(name="client_id",nullable=false)
	public Client client;
	
	public panier(int quantity,Client client,produit produit) {
		this.client=client;
		this.produit=produit;
		this.quantity=quantity;
	}

	@Override
	public String toString() {
		return "panier [quantity=" + quantity + ", produit=" + produit + ", client=" + client + "]";
	}

	
}
