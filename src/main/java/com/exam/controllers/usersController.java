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

import com.exam.models.user;
import com.exam.repositories.userRepository;


@Controller
public class usersController {
	@Autowired
    private userRepository usersRepository;
	@GetMapping("/users")
	public String getAllUsers(Model model){
		model.addAttribute("users",usersRepository.findAll());
		return "users";
	}
	@PostMapping("/users/add")
	public String add(@RequestBody user user) {
		 usersRepository.save(user);
		 return "redirect:/users";
	}
	@GetMapping("/users/edit/{id}")
	public String getById(@PathVariable Long id,Model model){
		//user user=usersRepository.findById(id);
		user user=new user();
		model.addAttribute("user",user);
				//.orElseThrow(() -> new ResourceNotFoundException("user not exist with id :" + id));
		
		return "editUser";
	}
	@PutMapping("/users/edit/{id}")
	public String UpdateUser(@PathVariable long id,@RequestBody user userDetails){
		user user = usersRepository.findById(id)
				.orElseThrow();
		user.setName(userDetails.name);
		user.setEmail(userDetails.email);
		user updatedUser = usersRepository.save(user);
		return "redirect:/users";
		
	}
	@GetMapping("/users/delete/{id}")
	public String DeleteUser(@PathVariable Long id){
		user user=userRepository.findById(id).orElseThrow();
		userRepository.delete(user);
		
		return "redirect:/users";
	}
	@GetMapping("/users/add")
	public String addUser(Model model) {
		user user=new user();
		model.addAttribute("user",user);
		return "addUser";
	}
	
}
