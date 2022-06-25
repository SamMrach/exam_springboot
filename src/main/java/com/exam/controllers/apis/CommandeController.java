package com.exam.controllers.apis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.exam.models.commande;
import com.exam.repositories.commandeRepository;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CommandeController {
    
	@Autowired
	commandeRepository commandeRepo;
	
	@GetMapping("/api/orders")
	public List<commande> getCommandes(){
		return commandeRepo.findAll();
		}
	@DeleteMapping("/api/orders/{id}")
	public void delete(@PathVariable("id") Long Id) {
		commande commandeToDel=commandeRepo.findById(Id).orElse(null);
		commandeRepo.delete(commandeToDel);
		
	}
}
