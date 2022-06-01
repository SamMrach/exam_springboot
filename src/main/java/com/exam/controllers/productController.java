package com.exam.controllers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.exam.models.produit;
import com.exam.models.user;
import com.exam.repositories.produitRepository;
import com.exam.repositories.userRepository;

@Controller
public class productController {
	@Autowired
    private produitRepository productsRepository;
	@GetMapping("/products")
	public String getAllProducts(Model model){
		model.addAttribute("products",productsRepository.findAll());
		return "produits";
	}
	@PostMapping("/products/add")
	public String add(@RequestBody produit produit) {
		productsRepository.save(produit);
		 return "redirect:/products";
	}
	@GetMapping("/products/edit/{id}")
	public String getById(@PathVariable Long id,Model model){
		//user user=usersRepository.findById(id);
		produit produit=new produit();
		model.addAttribute("produit",produit);
				//.orElseThrow(() -> new ResourceNotFoundException("user not exist with id :" + id));
		
		return "updateProduct";
	}
	@PutMapping("/products/edit/{id}")
	public String UpdateProduct(@PathVariable long id,@RequestBody produit productDetails){
		produit produit = produitRepository.findById(id)
				.orElseThrow();
		produit.setName(productDetails.name);
		produit.setDescription(productDetails.description);
		produit.setPrice(productDetails.price);
		
		produit updatedUser = productsRepository.save(produit);
		return "redirect:/products";
		
	}
	@GetMapping("/products/add")
	public String addProduct(Model model) {
		produit produit=new produit();
		model.addAttribute("product",produit);
		return "addProduct";
	}
	@GetMapping("/products/delete/{id}")
	public String DeleteProduct(@PathVariable Long id){
		produit produit=productsRepository.findById(id).orElseThrow();
		productsRepository.delete(produit);
		
		return "redirect:/products";
	}
}
