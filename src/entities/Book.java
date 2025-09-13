package entities;

import java.time.LocalDate;

import service.Status;

public class Book {

    private String title;
    private String author;
    private LocalDate date;
    private Status status;

    public Book() {
    	
    }
	public Book(String title, String author, LocalDate date) {
		this.title = title;
		this.author = author;
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public LocalDate getReturnDate() {
		return date;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.date = returnDate;

	public Status getStatus() {
		return status;
	}
	
	public void checkStatus (LocalDate date) {
		if (date.isBefore(date.now()) || date.equals(date.now())) {
			status = Status.AVAILABLE;
		}
		else {
			status = Status.BORROWED;
		}
	}

	@Override
	public String toString() {
		return "Book [title= " + title + ", author= " + author + ", status= " + status + "]";
	}
	
	
}
