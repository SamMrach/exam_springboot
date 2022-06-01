package com.exam.models;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Id;





@Entity
public class category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
   private String name;
   private String description;
   @OneToMany(mappedBy="categorie")
   private Collection<produit> produits;
}
