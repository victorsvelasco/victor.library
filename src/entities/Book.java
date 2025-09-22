package entities;

import java.util.Date;
import java.util.Objects;

import service.Status;

public class Book {

    private String title;
    private String author;
    private Date date;
    private Status status;

    public Book() {
    	
    }
    
    public Book(String title, String author) {
		this.title = title;
		this.author = author;
		this.status = Status.AVAILABLE;
	}

    
	public Book(String title, String author, Date date) {
		this.title = title;
		this.author = author;
		this.date = date;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date returnDate) {
		this.date = returnDate;
	}

	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
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

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Title: " + title);
		sb.append(", Author: " + author);
		sb.append(", Status: " + status + "\n");
		return sb.toString();
	}
	
}
