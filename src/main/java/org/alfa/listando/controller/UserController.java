package org.alfa.listando.controller;

import com.password4j.Hash;
import com.password4j.Password;
import jakarta.validation.Valid;
import org.alfa.listando.domain.User;
import org.alfa.listando.dto.UserDTO;
import org.alfa.listando.repositories.UserRepository;
import org.alfa.listando.services.UserService;
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
	UserService userService;
	
	@PostMapping("/users")
	public ResponseEntity<User> saveUser(@RequestBody @Valid UserDTO userDto) {
		User savedUser = userService.saveUser(userDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {
		return ResponseEntity.status(HttpStatus.OK).body(userService.allUsers());
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<Object> getOneUser(@PathVariable(value = "id") UUID id) {
		User user = userService.getOneUser(id);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable(value = "id")UUID id) {
		var user = userService.getOneUser(id);
		if (user != null) {
			userService.deleteUser(id);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
		}
		return ResponseEntity.ok().body("User deleted");
	}
	
//	@PutMapping("/users/{id}")
//	public ResponseEntity<Object> updateUser(@PathVariable(value = "id") UUID id,
//	                                         @RequestBody @Valid UserDTO userDTO) {
//		var user = userService.updatedUser();
//	}
	//TODO implementar
}
