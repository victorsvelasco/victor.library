package service;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entities.Book;

public class LibraryService {
	
	private static final List <Book> books = new ArrayList<Book>();
	
	// Method to register new book
	public void bookRegistration(Book book) {
		books.add(book);
	}
		
	// Method to borrow a book
	public void borrowBook(String title) {
		for (Book b : books) {
			if (b.getTitle().equals(title) && b.getStatus().equals(Status.AVAILABLE)){
				b.setStatus(Status.BORROWED);
				System.out.println("The book is now on loan to you.\n");
			}else if (b.getTitle().equals(title) && b.getStatus().equals(Status.BORROWED)){
				System.out.println("The selected book is already borrowed.\n");
			}
		}
	}
	
	// Method to return book
	public void returnBook (String title) {
		
		for (Book b : books) {
			if (b.getTitle().equals(title)) {
				if (b.getStatus() == Status.BORROWED){
					b.setStatus(Status.AVAILABLE);
					System.out.println("The book has been returned. \n");
				}
				else if(b.getStatus() == Status.LATE){
					Duration duration = Duration.between(b.getBorrowDate().plusDays(3), LocalDate.now());
					b.setStatus(Status.AVAILABLE);
					System.out.println("The book is " + duration + " days overdue. \n");
				}
				else{
					System.out.println("The book is already in stock. \n");
				}
			}
		}
	}
	
	public void returnBooksList() {
		for (Book b: books) {
			System.out.println(b);
		}
	}
	
	public void LateBook () {
		for (Book b : books) {
			if (b.getStatus() == Status.BORROWED && b.getBorrowDate().plusDays(3).isAfter(LocalDate.now())) {
				b.setStatus(Status.LATE);
			}
		}
	}
}
