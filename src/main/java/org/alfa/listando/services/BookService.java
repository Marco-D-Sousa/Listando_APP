package org.alfa.listando.services;

import org.alfa.listando.domain.Book;
import org.alfa.listando.dto.BookDTO;
import org.alfa.listando.repositories.BookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {

	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public List<Book> allBooks() {
		return bookRepository.findAll();
	}
	
	public Book oneBook(UUID id) {
		Optional<Book> bookO = bookRepository.findById(id);
		return bookO.orElse(null);
	}
	
	public Book saveBook(BookDTO bookDTO) {
		var book = new Book();
		BeanUtils.copyProperties(bookDTO, book);
		
		return bookRepository.save(book);
	}
}
