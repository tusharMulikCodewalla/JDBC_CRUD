package com.example.demo.repositories;

import java.util.List;

import com.example.demo.models.Book;

public interface BookRepository {
	int save(Book book);
	List<Book> findAll();
	int updateBookName(Book book);
	int deleteBookById(int bookId);
}
