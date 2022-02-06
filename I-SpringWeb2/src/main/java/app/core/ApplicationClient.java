package app.core;

import java.time.LocalDate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import app.core.entities.Book;

public class ApplicationClient {

	public static void main(String[] args) {
		
		//make request to: http://localhost:8080/books/1
		RestTemplate rt = new RestTemplate();
		
		//GET:
		String url = "http://localhost:8080/books/1";
		//get the response body only
		Book book = rt.getForObject(url, Book.class);
		System.out.println(">>>book: " + book);
		
		//get the response 
		ResponseEntity<Book> response = rt.getForEntity(url, Book.class);
		System.out.println(">>>response: " + response);
		System.out.println(">>>the status: " + response.getStatusCode());
		System.out.println(">>>the body: " + response.getBody());
	}
}
