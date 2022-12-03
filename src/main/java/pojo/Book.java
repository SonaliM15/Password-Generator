package pojo;

//This is pojo class : pojo: plain old java object
public class Book // Book is a pojo class which represents book data
{
	private int bookId;
	private String bookName;
	private double bookPrice;

	// To create empty book
	public Book() {

	}  

	// To create book without bookid data, as in sql we have auto-increment
	public Book(String bookName, double bookPrice) {
		
		this.bookName = bookName;
		this.bookPrice = bookPrice;
	}

	// To create book with all data
public Book(int bookId, String bookName, double bookPrice) {
		
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
	}

	// To access private variable outside class we create getter setter
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

	// To print book class object in string format else if object does not have any
	// data
	// and toString method is not present then printed object will return address in
	// hexadecimal number

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookPrice=" + bookPrice + "]";
	}

//	public static void main(String[] args) {
//
//		Book b1 = new Book();
//		Book b2 = new Book("Core Java", 450.36);
//		Book b3 = new Book(105, "Advance Java", 120.6);
//		System.out.println(b1);
//		System.out.println(b2);
//		System.out.println(b3);
//
//	}

}
