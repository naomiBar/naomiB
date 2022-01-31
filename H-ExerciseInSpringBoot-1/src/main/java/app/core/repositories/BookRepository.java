package app.core.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
	
	boolean existsByTitle(String title);
	
	List<Book> findBooksByAuthor(String author);
	
	List<Book> findBooksByTitleStartingWith(String prefix);

	List<Book> findBooksByPriceGreaterThanEqual(Double price);
	
	List<Book> findBooksByStockIs(Integer amount);
	
	List<Book> findBooksByPublicationBefore(LocalDate date);
	
	List<Book> findBooksByPublicationBetween(LocalDate startDate, LocalDate endDate);
	
    long countByTitle(String Title);
    
    boolean existsByAuthor(String author);

}