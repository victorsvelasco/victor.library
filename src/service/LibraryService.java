package service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import entities.Book;

public class LibraryService {
	
	private static final List <Book> books = new ArrayList<Book>();

	public void bookRegistration(Book book) {
	    // Check for missing information
	    if (book.getAuthor() == null || book.getTitle() == null) {
	        System.out.println("The book was not added to the list due to missing information.\n");
	        return;
	    }

	    // Add book to the list
	    books.add(book);
	    System.out.println("The book has been successfully registered.\n");
	}

	public void borrowBook(String title) {
	    boolean found = false;

	    for (Book b : books) {
	        // Match book title (ignore case)
	        if (b.getTitle().equalsIgnoreCase(title)) {
	            found = true;

	            if (b.getStatus() == Status.AVAILABLE) {
	                b.setStatus(Status.BORROWED);
	                b.setDate(LocalDate.now()); // record borrow date
	                System.out.println("The book is now on loan to you.\n");
	            } 
	            else if (b.getStatus() == Status.BORROWED || b.getStatus() == Status.LATE) {
	                System.out.println("The selected book is already borrowed.\n");
	            } 

	            return; // Stop after handling the book
	        }
	    }

	    // If no book found
	    if (!found) {
	        System.out.println("Book not found.\n");
	    }
	}
	
	public void returnBook(String title) {
	    boolean found = false;

	    for (Book b : books) {
	        // Match book title (ignore case)
	        if (b.getTitle().equalsIgnoreCase(title)) {
	            found = true;

	            if (b.getStatus() == Status.BORROWED) {
	                b.setStatus(Status.AVAILABLE);
	                b.setDate(null);
	                System.out.println("The book has been returned.\n");
	            } 
	            else if (b.getStatus() == Status.LATE) {
	                long daysLate = ChronoUnit.DAYS.between(b.getBorrowDate().plusDays(3), LocalDate.now());
	                b.setStatus(Status.AVAILABLE);
	                b.setDate(null);
	                System.out.println("The book is " + daysLate + " days overdue.\n");
	            } 
	            else {
	                System.out.println("The book is already in stock.\n");
	            }

	            return; // Stop after handling the book
	        }
	    }

	    // If no book found
	    if (!found) {
	        System.out.println("Book not found.\n");
	    }
	}

	
	public void returnBooksList() {
		for (Book b: books) {
			System.out.println(b);
		}
	}
	
	public void LateBook () {
		for (Book b : books) {
			 // If the book is borrowed and overdue
	        if (b.getStatus() == Status.BORROWED && b.getBorrowDate().plusDays(3).isBefore(LocalDate.now())) {
	            b.setStatus(Status.LATE);
	        }
		}
	}
}
