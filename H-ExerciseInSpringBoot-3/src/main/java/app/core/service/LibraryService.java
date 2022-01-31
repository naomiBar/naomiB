package app.core.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.core.entities.Book;
import app.core.entities.Library;
import app.core.repos.BookRepo;
import app.core.repos.LibraryRepo;

@Service
@Transactional
public class LibraryService {

	@Autowired
	private BookRepo bookRepo;
	@Autowired
	private LibraryRepo libraryRepo;
	
	public int addLibrary(Library library) {
		if(this.libraryRepo.existsById(library.getId())) {
			throw new RuntimeException("addLibrary failed - library id " + library.getId() + " already exists");			
		}
		library = libraryRepo.save(library);
		return library.getId();			
	}
	
	public int addBook(Book book) {
		if(this.bookRepo.existsById(book.getId())) {
			throw new RuntimeException("addBook failed - book id " + book.getId() + " already exists");			
		}
		book = bookRepo.save(book);
		return book.getId();
	}
	
	public void addBookToLibrary(Book book, int libraryId) {
		Optional<Library> opt = this.libraryRepo.findById(libraryId);
		if(opt.isPresent() && !this.bookRepo.existsById(book.getId())) {
			Library library = opt.get();
			library.addBook(book);
		}else {
			throw new RuntimeException("addBookToLibrary failed - NOT found library " + libraryId + " or book id " + book.getId() + " already exists");
		}
	}
	
	public void updateLibrary(Library library) {
		Optional<Library> opt = this.libraryRepo.findById(library.getId());
		if(opt.isPresent()) {
			this.libraryRepo.save(library);
		}else {
			throw new RuntimeException("updateLibrary failed - library id " + library.getId() + " NOT found");
		}
	}
	
	public void updateBook(Book book) {
		Optional<Book> opt = this.bookRepo.findById(book.getId());
		if(opt.isPresent()) {
			Book b = opt.get();
			if(book.getAuthor().equals(b.getAuthor())) {
				this.bookRepo.save(book);
			}else {
				throw new RuntimeException("updateBook failed - impossible to update book's author");
			}
		}else {
			throw new RuntimeException("updateBook failed - book id " + book.getId() + " NOT found");
		}
	}
	
	public Optional<Library> getOneLibrary(String name){
		return this.libraryRepo.findLibraryByName(name);
	}
	
	public Book getOneBook(int bookId) {
		Optional<Book> opt = this.bookRepo.findById(bookId);
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new RuntimeException("getOneBook failed - book id " + bookId + " NOT found");
	}
	
	public Book getOneBook(String title) {
		return this.bookRepo.findBookByTitle(title);
	}
	
	public List<Book> getBooksFromLibrary(int libraryId){
		return this.bookRepo.findBooksByLibraryId(libraryId);
	}
	
	public List<Book> getBooksByPublicationBefore(LocalDate date){
		return this.bookRepo.findBooksByPublicationBefore(date);
	}
	
	public List<Book> getBooksByPublicationAfter(LocalDate date){
		return this.bookRepo.findBooksByPublicationAfter(date);
	}
	
	public List<Book> getBooksByPublicationBetween(LocalDate startDate, LocalDate endDate){
		return this.bookRepo.findBooksByPublicationBetweenOrderByPublication(startDate, endDate); 
	}
	
	public List<Book> getBooksByAuthorStartingWith(String prefix){
		return this.bookRepo.findBooksByAuthorStartingWith(prefix);
	}
}
