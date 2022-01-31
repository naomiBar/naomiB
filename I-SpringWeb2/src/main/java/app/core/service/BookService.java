package app.core.service;

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
		return this.bookRepo.save(book).getId();
	}
	
	public Book getOneBook(int bookId) {
		Optional<Book> opt = this.bookRepo.findById(bookId);
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new RuntimeException("getOneBook failed - book id " + bookId + " not found");
	}
	
}
