package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Book;
import com.example.demo.repositories.BookRepository;

@RestController
@RequestMapping("/api/v1")
public class BookController {

	@Autowired
	private BookRepository bookRepository;
	
	@GetMapping("/books")
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}
	
	@PutMapping("/updateBook")
	public int updateBookName(@RequestBody Book book) {
		return bookRepository.updateBookName(book);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public int deleteBookById(@PathVariable(value = "id") int bookId) {
		return bookRepository.deleteBookById(bookId);
	}
	
	@PostMapping("/insertBooks")
	public int insertBook(@RequestBody Book book) {
		return bookRepository.save(book);
	}
}
