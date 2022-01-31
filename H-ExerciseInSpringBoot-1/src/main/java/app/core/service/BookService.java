package app.core.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.core.entities.Book;
import app.core.repositories.BookRepository;

@Service
@Transactional
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public int addBook(Book book) {
		if (this.bookRepository.existsByTitle(book.getTitle())) {
			throw new RuntimeException("addBook failed - book's title: " + book.getTitle() + " already exists");
		}
		book = this.bookRepository.save(book);
		return book.getId();
	}

	public Book getOneBook(int bookId) {
		Optional<Book> opt = this.bookRepository.findById(bookId);
		if (opt.isPresent()) {
			return opt.get();
		}
		throw new RuntimeException("getOneBook failed - book id " + bookId + " NOT found");
	}

	public List<Book> getAllBooks() {
		return this.bookRepository.findAll();
	}

	public void updateBook(Book book) {
		Optional<Book> opt = this.bookRepository.findById(book.getId());
		if (opt.isEmpty()) {
			throw new RuntimeException("updateBook failed - book id " + book.getId() + " NOT found");
		}
		Book b = opt.get();
		if (book.getTitle().equals(b.getTitle()) && book.getAuthor().equals(b.getAuthor())) {
			this.bookRepository.save(book);
		}else {
			throw new RuntimeException("updateBook failed - impossible to update book's title or author");
		}
	}
	
	public void deleteBook(int bookId) {
		Optional<Book> opt = this.bookRepository.findById(bookId);
		if(opt.isEmpty()) {
			throw new RuntimeException("deleteBook failed - book id " + bookId + " NOT found");			
		}
		this.bookRepository.deleteById(bookId);
	}
	
	public List<Book> getBooksByAuthor(String author){
		return this.bookRepository.findBooksByAuthor(author);
	}
	
	public List<Book> getBooksByTitleStartingWith(String prefix){
		return this.bookRepository.findBooksByTitleStartingWith(prefix);
	}
	
	public List<Book> getBooksByPriceGreaterThanEqual(Double price){
		return this.bookRepository.findBooksByPriceGreaterThanEqual(price);
	}
	
	public List<Book> getBooksByStockIs(Integer amount){
		return this.bookRepository.findBooksByStockIs(amount);
	}
	
	public List<Book> getBooksByPublicationBefore(LocalDate date){
		return this.bookRepository.findBooksByPublicationBefore(date);
	}

	public List<Book> getBooksByPublicationBetween(LocalDate startDate, LocalDate endDate){
		return this.bookRepository.findBooksByPublicationBetween(startDate, endDate);
	}
	
	public long countByTitle(String Title) {
		return this.bookRepository.countByTitle(Title);
	}
	
	public boolean existsByAuthor(String author) {
		return this.bookRepository.existsByAuthor(author);
	}
}
