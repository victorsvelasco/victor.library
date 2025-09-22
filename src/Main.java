import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Book;
import service.LibraryService;

public class Main {
    public static void main(String[] args) throws ParseException {
    	
    	Locale.setDefault(Locale.US);
    	Scanner sc = new Scanner(System.in);
    	
    	String title;
    	String author;
    	String date;
    	Date borrowDate;
    	LibraryService libraryService = new LibraryService();
    	Book book = new Book();
    	
    	System.out.printf(
    			"Choose an option below: \n"
    			+ "1 - Borrow book\n" // Borrow the book
    			+ "2 - Return book\n" // Return the book
    			+ "3 - Register books\n" // Register the book 
    			+ "0 - Exit\n" // exit of loop
    			);
    	
    	int numberChoice = sc.nextInt();
    	
    	do {
	    	switch (numberChoice) {
			case 1: {
				System.out.println("Which book would you like to borrow from the library?");
				System.out.println(libraryService.returnBooksList());
			}
			case 2: {
				
				
			}
			case 3: {
				System.out.println("Enter the book title followed by the author's name: ");
				title = sc.nextLine();
				sc.nextLine();
				author = sc.nextLine();
				libraryService.bookRegistration(new Book (title, author));
			}
		
			}
	    	
	    	System.out.printf(
	    			"Choose an option below: \n"
	    			+ "1 - Borrow book\n" // Borrow the book
	    			+ "2 - Return book\n" // Return the book
	    			+ "3 - Register books\n" // Register the book 
	    			+ "0 - Exit\n" // exit of loop
	    			);
	    	
	    	numberChoice = sc.nextInt();
	    	
    	}while (numberChoice != 0);
    	sc.close();
    }
}