package service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.Book;

public class LibraryService {
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
	
	private static final List <Book> books = new ArrayList<Book>();
	
	// Method to register new book
	public void bookRegistration(Book book) {
		if (!books.contains(book)) {
		books.add(book);
		}else {
			System.out.println("The book already exists and cannot be registered again.");
		}
	}
	
	
	// Method to borrow a book
	public void borrowBook(String title) {
		for (Book book : books) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(book.getDate());
			cal.add(Calendar.DAY_OF_MONTH, 3);
			sdf.format(cal);
			
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.getStatus() == Status.AVAILABLE) {
                    book.setStatus(Status.BORROWED);
                    System.out.println("The book must be returned by: " + cal);
                } else {
                    System.out.println("Book already borrowed!");
                }
            }
        }
	}
	
	public Book returnBooksList () {
		return (Book) books;	
	}
}
