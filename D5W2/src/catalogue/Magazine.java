package catalogue;

public class Magazine extends AbstractBook{
	
	String periodicity;
	
	public Magazine(String title, int releaseYear, int pages, String periodicity) {
		super();
		super.title = title;
		super.releaseYear = releaseYear;
		super.pages = pages;
		this.periodicity = periodicity;
	}
	
	public String toString() {
		return "ISBN: " + this.isbn + ", Title: " + this.title + ", Year: " + this.releaseYear + ", Pages: " + this.pages + ", Periodicity: " + this.periodicity;
 	}
}

	