package com.exam.models;


import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties({})
@Entity
public class commande implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public commande() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="order_id")
    public Long Id;
  private int quantity;
   
  public commande(int quantity,Client client,produit produit) {
	  this.quantity=quantity;
	  this.client=client;
	  this.produit=produit;
  }
  @ManyToOne()
  @JoinColumn(name="client_id",nullable=false)
  public Client client;
  
  @ManyToOne()
  @JoinColumn(name="produit_id",nullable=false)
  public produit produit;

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

@Override
public String toString() {
	return "commande [Id=" + Id + ", quantity=" + quantity + ", client=" + client + ", produit=" + produit + "]";
}


}
