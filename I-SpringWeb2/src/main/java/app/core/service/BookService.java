package app.core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.core.entities.Book;
import app.core.repos.BookRepo;

@Service
@Transactional
public class BookService {
	
	@Autowired
	private BookRepo bookRepo;
	
	public int addBook(Book book) {
		if(this.bookRepo.existsById(book.getId())) {
			throw new RuntimeException("addBook failed - book id " + book.getId() + " already exists");			
		}
		return this.bookRepo.save(book).getId();
	}
	
	public Book getOneBook(int bookId) {
		Optional<Book> opt = this.bookRepo.findById(bookId);
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new RuntimeException("getOneBook failed - book id " + bookId + " NOT found");
	}
	
	public List<Book> getAllBooks(){
		return this.bookRepo.findAll();
	}
	
	public void updateBook(Book book) {
		if(this.bookRepo.existsById(book.getId())) {
			this.bookRepo.save(book); //update
		}else {
			throw new RuntimeException("updateBook failed - book id " + book.getId() + " NOT found");
		}
	}
	
	public void deleteBook(int bookId) {
		if(this.bookRepo.existsById(bookId)) {
			this.bookRepo.deleteById(bookId);
		}else {
			throw new RuntimeException("deleteBook failed - book id " + bookId + " NOT found");			
		}
	}
	
}
