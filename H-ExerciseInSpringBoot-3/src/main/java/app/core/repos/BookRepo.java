package app.core.repos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.entities.Book;

public interface BookRepo extends JpaRepository<Book, Integer>{

	Book findBookByTitle(String title);
	
	List<Book> findBooksByLibraryId(int libraryId);
	
	List<Book> findBooksByPublicationBefore(LocalDate date);
	
	List<Book> findBooksByPublicationAfter(LocalDate date);
	
	List<Book> findBooksByPublicationBetweenOrderByPublication(LocalDate startDate, LocalDate endDate);
	
	List<Book> findBooksByAuthorStartingWith(String prefix);
}
