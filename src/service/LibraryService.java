package service;

import java.util.ArrayList;
import java.util.List;

import entities.Book;

public class LibraryService {
	
	private static final List <Book> books = new ArrayList<Book>();
	
	public void bookRegistration(Book book) {
		if (books.contains(book)) {
		books.add(book);
		}else {
			System.out.println("The book already exists and cannot be registered again.");
		}
	}
	
		
}
