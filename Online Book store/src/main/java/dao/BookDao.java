package dao;

import java.util.*;
import pojo.*;
import java.sql.*;

// Dao: Data Access Object
//It is used to access the data of book from database.
//i.e using dao class we can add,update,delete and read data of books with database
public class BookDao implements I_BookDao 
{
	Connection con = null;
	Statement stmt = null; // used for static sql queries
	ResultSet rs = null; // used for dynamic sql queries
	PreparedStatement ps = null;

	private Connection getCon() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // Driver Registration
			// Establish connection
			String url = "jdbc:mysql://localhost:3306/book";
					   //"jdbc:database://localhost:portnumber/database name"
			String user = "root";
			String password = "";
			//Connection con;
			// Declaring connection
			
			con = DriverManager.getConnection(url, user, password);
			return con; // if connected with db then returns connection

		} catch (Exception e) {

			e.printStackTrace();

		}
		return null; // if not able to connect with db then return null

	}

	public void addBook(Book book) // here book is variable of type Book class
	{

		try {
			con = getCon(); // established connection using getCon method with its returned object

			// ? represents data of book 1st for book name and 2nd for book price
			ps = con.prepareStatement("insert into book (bookName, bookPrice) values (?,?)");

			// ( ? number, calling book class function)
			ps.setString(1, book.getBookName());
			ps.setDouble(2, book.getBookPrice());
			int row = ps.executeUpdate();
			System.out.println(row + " rows inserted.");

			ps.close();
			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public List<Book> getAllBooks() // here we will be reading book list from database.
	{
		List<Book> nlist = new ArrayList<Book>(); // Created empty list

		try {
			con = getCon(); // established connection using getCon method with its returned object
			stmt = con.createStatement(); // created ability to create statement
			rs = stmt.executeQuery("select * from book"); // executed query

			while (rs.next()) {
				Book book = new Book(rs.getInt(1), rs.getString(2), rs.getDouble(3));
				nlist.add(book); // above data is stored in book list
			}

			rs.close();
			stmt.close();
			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return nlist;
	}

	public boolean deleteBook(int id) {

		con = getCon();
		try {
			ps = con.prepareStatement("delete from book where bookId = ?");
			ps.setInt(1, id);
			int row = ps.executeUpdate();
			ps.close();
			con.close();
			if (row > 0) {
				
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
	
	
	public boolean updateBook(int id, Book book)
	{
		
		con = getCon();
		try {
			ps= con.prepareStatement("update book set bookName=?, bookPrice=? where bookId=?");
			ps.setString(1,book.getBookName());
			ps.setDouble(2,book.getBookPrice());
			ps.setInt(3, id);
			int row = ps.executeUpdate();
			ps.close();
			con.close();
			if (row > 0)
			{return true;}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}
	
	public Book showBookById(int id) {
		con = getCon();
		
		try {
			ps = con.prepareStatement("select * from book where bookId=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				Book book = new Book(rs.getInt(1), rs.getString(2), rs.getDouble(3));
				return book;
			}
			rs.close();
			ps.close();

			con.close();

			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;

	}

//	public static void main(String[] args) {
//
//		Book b1 = new Book("Core Java", 400);
//		BookDao bookdao = new BookDao();
//		bookdao.addBook(b1);
//
//		List<Book> blist = bookdao.getAllBooks();
//		for (Book bk:blist)
//		{
//		System.out.println(bk);
//		}
//	}
}
