package org.alfa.listando.controller;

import org.alfa.listando.domain.Book;
import org.alfa.listando.repositories.BookRepository;
import org.alfa.listando.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/books")
	public ResponseEntity<Book> getAllBooks() {
	
	}
}
