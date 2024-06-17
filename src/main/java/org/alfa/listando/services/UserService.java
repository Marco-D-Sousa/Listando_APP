package org.alfa.listando.services;

import com.password4j.Hash;
import com.password4j.Password;
import org.alfa.listando.domain.User;
import org.alfa.listando.dto.UserDTO;
import org.alfa.listando.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<User> allUsers() {
		return userRepository.findAll();
	}
	
	public User getOneUser(UUID id) {
		Optional<User> userO = userRepository.findById(id);
		return userO.orElse(null);
	}
	
	public User saveUser(UserDTO userDTO) {
		var user = new User();
		BeanUtils.copyProperties(userDTO, user);
		
		Hash hash = Password.hash(user.getPassword()).withBcrypt();
		
		user.setPassword(hash.getResult());
		return userRepository.save(user);
	}
	
	public void deleteUser(UUID id) {
		userRepository.deleteById(id);
	}
	
	public User updatedUser(UserDTO userDTO, String newPassword) {
		//TODO implementar
		return null;
	}
}
