package app.core;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Book;
import app.core.service.BookService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		BookService bookService = ctx.getBean(BookService.class);
		
		bookService.addBook(new Book(0, "Java", "Naomi", LocalDate.now(), 99, 67));
//error:bookService.addBook(new Book(0, "Java", "Odel", LocalDate.now(), 88, 56));
		bookService.addBook(new Book(0, "Python", "Odel", LocalDate.of(2022, 9, 2), 88, 56));
		
		bookService.updateBook(new Book(1, "Java", "Naomi", LocalDate.now(), 84, 87));
		System.out.println(">>book: " + bookService.getOneBook(1));
		bookService.deleteBook(1);
		
		
//error:bookService.updateBook(new Book(0, "Python-1", "Odel", LocalDate.now(), 88, 56));
		
//error:bookService.deleteBook(5);
		
		bookService.addBook(new Book(0, "Python-2", "Odel", LocalDate.of(2022, 7, 2), 78, 0));
		
		System.out.println(">>all books: " + bookService.getAllBooks());
		
		String author = "odel";
		System.out.println(">>all books by " + author + ": " + bookService.getBooksByAuthor(author));
		
		String prefix = "p";
		System.out.println(">>all books by title that starting with " + prefix + ": " + bookService.getBooksByTitleStartingWith(prefix));
		
		double price = 78;
		System.out.println(">>all books up to a price of " + price + " (inclusive): " + bookService.getBooksByPriceGreaterThanEqual(price));
		
		System.out.println(">>all books out of stock: " + bookService.getBooksByStockIs(0));
		
		LocalDate date = LocalDate.of(2022, 8, 2);
		System.out.println(">>all books until " + date + ": " + bookService.getBooksByPublicationBefore(date));
		
		LocalDate startDate = LocalDate.of(2022, 9, 1);
		LocalDate endDate = LocalDate.of(2022, 9, 30);
		System.out.println(">>all books between " + startDate + " - " + endDate + ": " + bookService.getBooksByPublicationBetween(startDate, endDate));
		
		String title = "python";
		System.out.println(">>number of books with the title '" + title + "': " + bookService.countByTitle(title));
		
		System.out.println(">>are there any books by the author '" + author + "': " + bookService.existsByAuthor(author));
	}
}
