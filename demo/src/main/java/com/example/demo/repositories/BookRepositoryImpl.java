package com.example.demo.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Book;

@Repository
public class BookRepositoryImpl implements BookRepository{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int save(Book book) {
		return jdbcTemplate.update("INSERT INTO Books(name, price) values(?,?)",book.getName(), book.getPrice());
	}
	
	@Override
	public int updateBookName(Book book) {
		return jdbcTemplate.update("update Books set name = ? where id = ?", book.getName(), book.getId());
	}
	
	@Override
	public List<Book> findAll()
	{
		return jdbcTemplate.query("SELECT * FROM Books",
				(rs, rowNum)->
								new Book(rs.getLong("id"),
										rs.getString("name"),
										rs.getBigDecimal("price")
										)
		);
	}
	
	@Override
	public int deleteBookById(int bookId) {
		
		return jdbcTemplate.update("DELETE FROM Books WHERE id = ?", bookId);
	}

}


































