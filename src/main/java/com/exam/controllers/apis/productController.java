package com.exam.controllers.apis;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.exam.models.Client;
import com.exam.models.category;
import com.exam.models.commande;
import com.exam.models.panier;
import com.exam.models.produit;
import com.exam.repositories.categoryRepository;
import com.exam.repositories.commandeRepository;
import com.exam.repositories.panierRepository;
import com.exam.repositories.produitRepository;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class productController {
 
	@Autowired
	produitRepository prodRepo;
	@Autowired
	panierRepository panierRepo;
	@Autowired
	commandeRepository commandeRepo;
	@Autowired
	categoryRepository cateRepo;
	
	
	@GetMapping("/api/produits")
	public List<produit> getAllProduits(){
		return prodRepo.findAll();
	}
	@GetMapping("/api/produits/{id}")
	public produit getProduit(@PathVariable("id") Long id) {
		return prodRepo.findById(id).orElse(null);
	}
	@PostMapping("/api/produits/{id}")
	public produit addProduit(@RequestBody produit pro,@PathVariable(name="id") Long id) {
		category categorie=cateRepo.findById(id).orElse(null);
		pro.setCategorie(categorie);
		return prodRepo.save(pro);
	}
	@PutMapping("/api/produits/{id}")
	public produit updateProduit(@PathVariable("id") Long id,@RequestBody produit prodDetails) {
		produit prod=prodRepo.findById(id).orElse(null); 
		prod.setName(prodDetails.getName());
		prod.setDescription(prodDetails.getDescription());
		prod.setPrice(prodDetails.getPrice());
		return prodRepo.save(prod);
	}
	
	@DeleteMapping("/api/produits/{id}")
	public void deleteProduit(@PathVariable("id") Long id) {
		produit prod=prodRepo.findById(id).orElse(null);
		prodRepo.delete(prod);
		
	}
	@GetMapping("/api/produits/search/{keyword}")
	public List<produit> getAllProduits(@PathVariable("keyword") String keyword){
		return prodRepo.findByNameContainingIgnoreCase(keyword);
	}
	
	@PostMapping("/api/produits/panier")
	public panier addPanier(@RequestBody panier panierDetails) {
		
		//System.out.print(panierDetails.produit);
		//return panierDetails.getClient();
		panier new_panier=new panier();
		new_panier.setClient(panierDetails.getClient());
		new_panier.setProduit(panierDetails.getProduit());
		new_panier.setQuantity(panierDetails.getQuantity());
		
		return panierRepo.save(new_panier);
	}
	@DeleteMapping("/api/produits/panier/remove/{id}")
	public void deletePanier(@PathVariable("id") Long id) {
		panier panier=panierRepo.findById(id).orElse(null);
		panierRepo.delete(panier);
	}
	@GetMapping("/api/produits/panier/{id}")
	public List<produit> produitsPanier(Long id){
		return panierRepo.findProduitsByPanier(id);
	}
	@PostMapping("/api/produits/panier/commander/{id}")
	public void commander(@PathVariable("id") Long id){
		List<panier> paniers=panierRepo.findPaniersById(id);
		for(panier item:paniers) {
			commandeRepo.save(new commande(item.getQuantity(),item.client,item.produit));
		}
	}
    
}
