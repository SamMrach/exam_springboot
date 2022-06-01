package com.exam.models;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;

import javax.persistence.Id;

@Entity
public class panier {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "panier_produits",
            joinColumns = {@JoinColumn(name = "panier_id")},
            inverseJoinColumns = @JoinColumn(name = "produit_id")
    )
	private Collection<produit> produits;
	@OneToOne(mappedBy="panier")
	private user user;
}
