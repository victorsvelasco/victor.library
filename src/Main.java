import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import entities.Book;

public class Main {
    public static void main(String[] args) {
    	
    	Locale.setDefault(Locale.US);
    	Scanner sc = new Scanner(System.in);
    	
    	String tittle;
    	String author;
    	LocalDate date = LocalDate.now();
    	
    	ArrayList <Book> books = new ArrayList<>();
    	
    	books.add(new Book("Moby Dick", "Herman Melville", date));
    	
    	
    	System.out.printf(
    			"Choose an option below: \n"
    			+ "1 - Borrow book\n" // Pegar livro emprestado
    			+ "2 - Return book\n" // Devolver livro
    			+ "3 - Register books" // Registrar livro
    			);
    	
    	int numberChoice = sc.nextInt();
    	switch (numberChoice) {
		case 1: {
			System.out.println(books);
		}
		case 2: {
			
			
		}
		case 3: {
			
		}
	
		}
    	sc.close();
    }
}