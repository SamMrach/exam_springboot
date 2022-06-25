package com.exam.controllers.apis;

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

import com.exam.models.Client;
import com.exam.repositories.clientRepository;



@RestController
@CrossOrigin(origins = "*")
public class clientController {
 
	@Autowired
	public clientRepository clientRepo;
	@GetMapping("/api/clients")
	public List<Client> getClients(){
		return clientRepo.findAll();
	}
	@GetMapping("/api/client/{id}")
	public Client getClient(@PathVariable("id") Long id){
		return clientRepo.findById(id).orElse(null);
	}
	@PostMapping(value = "/api/clients")
	//@PostMapping(value="/api/clients/")
	public Client addClient(@RequestBody Client clientDetails) {
		return clientRepo.save(clientDetails);
	}
	@PutMapping("/api/clients/{id}")
	public Client updateClient(@PathVariable("id") Long id,@RequestBody Client clientDetails) {
		Client client=clientRepo.findById(id).orElse(null);
		client.setName(clientDetails.getName());
		client.setEmail(clientDetails.getEmail());
		client.setPassword(clientDetails.getPassword());
		client.setAdress(clientDetails.getAdress());
		return clientRepo.save(client);
	}
	@DeleteMapping("/api/clients/{id}")
	public void deleteClient(@PathVariable("id") Long id) {
		Client client=clientRepo.findById(id).orElse(null);
		clientRepo.delete(client);
	}
	
}
