package application;

import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

import entities.Book;
import service.LibraryService;

public class Main {
    public static void main(String[] args) throws ParseException {
    	
    	Locale.setDefault(Locale.US);
    	Scanner sc = new Scanner(System.in);
    	
    	LibraryService libraryService = new LibraryService();
    	
    	libraryService.bookRegistration(new Book("b1", "TorVic"));
    	libraryService.bookRegistration(new Book("b2" , "TorVic"));
    	libraryService.bookRegistration(new Book("b3", "TorVic"));
    	
    	//Menu de escolhas
    	System.out.printf(
    			"Choose an option below: \n"
    			+ "1 - Borrow book\n" // Emprestar livro
    			+ "2 - Return book\n" // Devolver livro
    			+ "3 - Register books\n" // Registrar livro 
    			+ "0 - Exit\n" // Sair do menu
    			);
    	
    	int numberChoice = sc.nextInt();    	
    	do {
	    	switch (numberChoice) {
			case 1: 
				System.out.println("Which book would you like to borrow?");
				libraryService.returnBooksList();
				sc.nextLine();
				String title = sc.nextLine();
				libraryService.borrowBook(title);				
				break;
			
			case 2: 
				System.out.println("Please enter the title of the book you wish to return.");
				sc.nextLine();
				title = sc.nextLine();
				libraryService.returnBook(title);
				break;
			
			case 3:
				System.out.println("Enter the book title followed by the author's name and release date: ");
				System.out.print("Title: ");
				sc.nextLine();
				title = sc.nextLine();
				System.out.print("Author: ");
				String author = sc.nextLine();
				libraryService.bookRegistration(new Book (title, author));
				
				break;
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