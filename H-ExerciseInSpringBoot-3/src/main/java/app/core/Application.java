package app.core;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Book;
import app.core.entities.Library;
import app.core.service.LibraryService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		LibraryService libraryService = ctx.getBean(LibraryService.class);
		
		Book book = new Book(0, "JAVA", "Naomi", LocalDate.of(2022, 1, 28), null);
		addBook(libraryService, book);
		
		Library library = new Library(0, "Library 1", "Jerusalem", null);
		int library1Id = addLibrary(libraryService, library);
		
		library = new Library(0, "Library 2", "Tel Aviv", null);
		int library2Id = addLibrary(libraryService, library);
		
		for (int i = 1; i <= 10; i++) {
			book = new Book(0, "library1-book " + i, "Naomi", LocalDate.of(2022, 8, 3), null);
			libraryService.addBookToLibrary(book, library1Id);
			book = new Book(0, "library2-book " + i, "Odel", LocalDate.of(2022, 7, 4), null);
			libraryService.addBookToLibrary(book, library2Id);
		}
		
		libraryService.updateLibrary(new Library(library1Id, "Library-1", "Jerusalem", null));
		libraryService.updateLibrary(new Library(library2Id, "Library-2", "Tel Aviv", null));
		
		printBooksFromLibrary(libraryService, library1Id);
		printBooksFromLibrary(libraryService, library2Id);
		
//error:libraryService.updateBook(new Book(1, "JAVA-1", "Naomi Bar", LocalDate.now(), null));
		libraryService.updateBook(new Book(1, "JAVA-1", "Naomi", LocalDate.now(), null));
		System.out.println(">>>book: " + libraryService.getOneBook(1));
		System.out.println(">>>book: " + libraryService.getOneBook("java-1"));
		
		Optional<Library> opt = libraryService.getOneLibrary("library-1");
		if(opt.isPresent()) {
			System.out.println(">>>library: " + opt.get());
		}
		
		LocalDate date = LocalDate.of(2022, 7, 29);
		System.out.println(">>>BooksByPublicationBefore " + date + ": " + libraryService.getBooksByPublicationBefore(date));
		System.out.println("=====================================================");
		System.out.println(">>>BooksByPublicationAfter " + date + ": " + libraryService.getBooksByPublicationAfter(date));
		System.out.println("=====================================================");
		LocalDate startDate = LocalDate.of(2022, 1, 27);
		LocalDate endDate = LocalDate.of(2022, 1, 29);
		System.out.println(">>>BooksByPublicationBetween " + startDate + " - " + endDate + ": " + libraryService.getBooksByPublicationBetween(startDate, endDate));
		
		System.out.println("=====================================================");
		System.out.println(">>>BooksByAuthorStartingWith 'na': " + libraryService.getBooksByAuthorStartingWith("na"));
	}


	private static int addLibrary(LibraryService libraryService, Library library) {
		int libraryId = libraryService.addLibrary(library);
		System.out.println("libraryId: " + libraryId);
		return libraryId;
	}

	private static int addBook(LibraryService libraryService, Book book) {
		int bookId = libraryService.addBook(book);
		System.out.println("bookId: " + bookId);
		return bookId;
	}
	
	private static void printBooksFromLibrary(LibraryService libraryService, int libraryId) {
		List<Book> books = libraryService.getBooksFromLibrary(libraryId);
		System.out.println("\n\t Book from Library " + libraryId + ":");
		for (Book book : books) {
			System.out.println(">> book: " + book);
		}
	}
}
