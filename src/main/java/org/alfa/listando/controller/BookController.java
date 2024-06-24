package org.alfa.listando.controller;

import jakarta.validation.Valid;
import org.alfa.listando.domain.Book;
import org.alfa.listando.domain.User;
import org.alfa.listando.dto.BookDTO;
import org.alfa.listando.repositories.BookRepository;
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
public class BookController {

	@Autowired
	BookRepository bookRepository;

	@Autowired
	UserRepository userRepository;

	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBooks() {
		return ResponseEntity.status(HttpStatus.OK).body(bookRepository.findAll());
	}

	@GetMapping("/books/{id}")
	public ResponseEntity<Object> getOneBook(@PathVariable(value = "id") UUID id) {
		Optional<Book> bookO = bookRepository.findById(id);
		if (bookO.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");
		}
		return ResponseEntity.status(HttpStatus.OK).body(bookO.get());
	}

	//TODO ajustar o funcionamento da inclusão de livros
	@PostMapping("/books")
	public ResponseEntity<Book> saveBook(@RequestBody @Valid BookDTO bookDTO) {

		var book = new Book();
		BeanUtils.copyProperties(bookDTO, book);

		var userId = book.getUser();

		System.out.println(userId);
		return ResponseEntity.status(HttpStatus.CREATED).body(book);
	}
}
