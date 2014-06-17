package bookstore;

public class TBook {
	
	private String isbn;
	private String title;
	private String author;
	private String publisher;
	private String price;
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public  String getTitle() {
		return title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public  String getAuthor() {
		return author;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPrice() {
		return price;
	}

}
