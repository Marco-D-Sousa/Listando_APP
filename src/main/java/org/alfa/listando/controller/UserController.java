package org.alfa.listando.controller;

import jakarta.validation.Valid;
import org.alfa.listando.domain.User;
import org.alfa.listando.dto.UserDTO;
import org.alfa.listando.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/users")
	public ResponseEntity<User> saveUser(@RequestBody @Valid UserDTO userDTO) {
		var user = new User();
		BeanUtils.copyProperties(userDTO, user);
		return ResponseEntity.status(HttpStatus.CREATED).body(userRepository.save(user));
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {
		return ResponseEntity.status(HttpStatus.OK).body(userRepository.findAll());
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<Object> getOneUser(@PathVariable(value = "id") UUID id) {
		Optional<User> userO = userRepository.findById(id);
		if (userO.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
		}
		return ResponseEntity.status(HttpStatus.OK).body(userO.get());
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<Object> updateUser(@PathVariable(value = "id") UUID id,
	                                         @RequestBody @Valid UserDTO userDTO) {
		Optional<User> userO = userRepository.findById(id);
		if (userO.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
		}
		var user = userO.get();
		BeanUtils.copyProperties(userDTO, user);
		return ResponseEntity.status(HttpStatus.OK).body(userRepository.save(user));
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable(value = "id")UUID id) {
		Optional<User> userO = userRepository.findById(id);
		if (userO.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
		}
		userRepository.delete(userO.get());
		return ResponseEntity.status(HttpStatus.OK).body("User deleted");
	}
}

//TODO Ajustar as validações e colocar os services