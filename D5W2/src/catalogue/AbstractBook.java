package catalogue;

public abstract class AbstractBook {
	
	protected long isbn;
	protected String title;
	protected int releaseYear;
	protected int pages;
	
	static long staticIsbn = 10000000;
	
	protected AbstractBook() {
		this.isbn = staticIsbn;
		staticIsbn++;
	}
	
	public long getIsbn() {
		return this.isbn;
	}
	
	public int getYear() {
		return this.releaseYear;
	}
}
