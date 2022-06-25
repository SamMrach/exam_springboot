package com.exam.controllers.apis;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.models.category;
import com.exam.models.produit;
import com.exam.repositories.categoryRepository;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class categoryController {
 
	@Autowired
	categoryRepository cateRepo;
	
	@GetMapping("/api/categories")
	public List<category> getAllcategories(){
		return cateRepo.findAll();
	}
	@GetMapping("/api/categories/{id}")
	public category getCategory(@PathVariable("id") Long id) {
		return cateRepo.findById(id).orElse(null);
	}
	@PostMapping(value="/api/categories")
	public category addCategory(@RequestBody category cat) {
		return cateRepo.save(cat);
	}
	@PutMapping("/api/categories/{id}")
	public category updateCategory(@PathVariable("id") Long id,@RequestBody category catDetails) {
		category cat=cateRepo.findById(id).orElse(null);
		cat.setName(catDetails.getName());
		cat.setDescription(catDetails.getDescription());
		return cateRepo.save(cat);
	}
	@DeleteMapping("/api/categories/{id}")
	public void deleteCate(@PathVariable("id") Long id) {
		category cat=cateRepo.findById(id).orElse(null);
		cateRepo.delete(cat);
	}
	
	@GetMapping("/api/categories/{id}/produits")
	public Collection<produit> getProduitsByCate(@PathVariable("id") Long id){
		category cat=cateRepo.findById(id).orElse(null);
		return cat.produits;
	}
}
