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

        // Initial books
        libraryService.bookRegistration(new Book("b1", "TorVic"));
        libraryService.bookRegistration(new Book("b2", "TorVic"));
        libraryService.bookRegistration(new Book("b3", "TorVic"));

        int numberChoice;

        do {
            // Menu
            System.out.printf("""
                Choose an option below:
                1 - Borrow book
                2 - Return book
                3 - Register books
                0 - Exit
                """);

            while (!sc.hasNextInt()) { // prevent input error
                System.out.println("Please enter a valid number.");
                sc.next();
            }
            numberChoice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (numberChoice) {
                case 1:
                    System.out.println("Which book would you like to borrow?");
                    libraryService.returnBooksList();
                    String title = sc.nextLine();
                    libraryService.borrowBook(title);
                    break;

                case 2:
                    System.out.println("Enter the title of the book you wish to return:");
                    title = sc.nextLine();
                    libraryService.returnBook(title);
                    break;

                case 3:
                    System.out.println("Enter book information:");
                    System.out.print("Title: ");
                    title = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    libraryService.bookRegistration(new Book(title, author));
                    break;

                case 0:
                    System.out.println("Exiting the program...");
                    break;

                default:
                    System.out.println("Invalid option. Try again.\n");
                    break;
            }

        } while (numberChoice != 0);

        sc.close();
    }
}
