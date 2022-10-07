package catalogue;

public class Book extends AbstractBook{
	
	String author;
	String genre;
	
	public Book(String author, String genre, String title, int releaseYear, int pages) {
		super();
		this.author = author;
		this.genre = genre;
		super.title = title;
		super.releaseYear = releaseYear;
		super.pages = pages;
	}
	
	public String getAuthor() {
		return this.author;
	}
	
	public String toString() {
		return "ISBN: " + this.isbn + ", Title: " + this.title + ", Author: " + this.author + ", Genre: " + this.genre + ", Year: " + this.releaseYear + ", Pages: " + this.pages;
 	}
}
