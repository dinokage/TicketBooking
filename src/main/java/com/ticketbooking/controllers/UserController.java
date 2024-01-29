package com.ticketbooking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.ticketbooking.dto.SignInDTO;
import com.ticketbooking.dto.UserCheckDTO;
import com.ticketbooking.dto.UserDTO;
import com.ticketbooking.entities.User;
import com.ticketbooking.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
@Validated
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<?> registerUser(@RequestBody @Valid UserDTO userDTO) {
		userService.saveUser(userDTO);
		return ResponseEntity.ok().body("User registered successfully");
	}

	
	@PostMapping("/validate") 
	  public ResponseEntity<?> validateUser(@RequestBody @Valid SignInDTO signInDTO) { 
		  UserCheckDTO user = userService.validate(signInDTO); 
		  if (user != null) { 
			  return ResponseEntity.ok(user); 
			  } 
		  else { 
			  return ResponseEntity.badRequest().body("Invalid username or password"); 
			  } 
		  }
	 

	@GetMapping
	public ResponseEntity<?> listAllUsers() {
		return ResponseEntity.ok(userService.listAll());
	}

	@GetMapping("{id}")
	public ResponseEntity<?> findUserDetails(@PathVariable("id") int id) {
		return ResponseEntity.ok().body(userService.findById(id));
	}
}
