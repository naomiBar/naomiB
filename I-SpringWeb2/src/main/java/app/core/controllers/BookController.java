package app.core.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.core.entities.Book;
import app.core.service.BookService;

@RestController
@RequestMapping("/books") //http://localhost:8080/books
public class BookController {

	@Autowired
	private BookService bookService;
	
	//http://localhost:8080/books?bookId=125 -> request parameter
	//http://localhost:8080/books/125 -> path variable
	@GetMapping(path = "/{bookId}")
	public Book getOneBook(@PathVariable int bookId) {
		return this.bookService.getOneBook(bookId);
	}
	
	@PostMapping
	public int addBook(@RequestBody Book book) {
		return this.bookService.addBook(book);
	}
}
