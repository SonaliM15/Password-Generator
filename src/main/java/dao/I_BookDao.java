package dao;

import java.util.List;

import pojo.Book;

//Here we are creating blue print of BookDao class. wherein it is mandatory to implement all below defined functions in BookDao class

public interface I_BookDao {

	public void addBook(Book book);

	public List<Book> getAllBooks();

	public boolean deleteBook(int id);

	public boolean updateBook(int id, Book book);

}
