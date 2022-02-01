package app.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PostMapping(consumes =  {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> addBook(@RequestBody Book book) {
		try {
			return ResponseEntity.ok("book's id: " + this.bookService.addBook(book));
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	//http://localhost:8080/books?bookId=125 -> request parameter
	//http://localhost:8080/books/125 -> path variable
//	@GetMapping(path = "/{bookId}", produces = {"application/json", "application/xml"})
	@GetMapping(path = "/{bookId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> getOneBook(@PathVariable int bookId) {
		try {
			Book book = this.bookService.getOneBook(bookId);
			return new ResponseEntity<>(book, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<Book> getAllBooks(){
		return this.bookService.getAllBooks();
	}
	
	@PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> updateBook(@RequestBody Book book){
		try {
			this.bookService.updateBook(book);
			return ResponseEntity.ok("book updated: " + book);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@DeleteMapping(path = "/{bookId}")
	public ResponseEntity<?> deleteBook(@PathVariable int bookId){
		try {
			this.bookService.deleteBook(bookId);
			return ResponseEntity.ok("book id " + bookId + " deleted");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
}
