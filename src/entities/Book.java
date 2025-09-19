package entities;

import java.time.LocalDate;
import java.util.Objects;

import service.Status;

public class Book {

    private String title;
    private String author;
    private LocalDate date;
    private Status status;

    public Book() {
    	
    }
	public Book(String title, String author) {
		this.title = title;
		this.author = author;
		this.status = Status.AVAILABLE;
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
	}

	public Status getStatus() {
		return status;
	}
	@Override
	public int hashCode() {
		return Objects.hash(author, title);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && Objects.equals(title, other.title);
	}
	
}
