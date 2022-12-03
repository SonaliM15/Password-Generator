package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookDao;
import pojo.Book;

@WebServlet("/bookurl")
public class BookController extends HttpServlet {

	List<Book> blist = null;
	BookDao bookDao = new BookDao();
	String action;
	Book book = new Book();
	HttpSession session = null;
	String bookName;
	double bookPrice;
	int bookId;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		action = req.getParameter("action");
		session = req.getSession();

		if (action != null && action.equals("list")) {
			blist = bookDao.getAllBooks();
			session.setAttribute("blist", blist);
			resp.sendRedirect("booklist.jsp");
		} else if (action != null && action.equals("add")) {
			book = new Book(0, "", 0);
			req.setAttribute("action", "add");
			req.setAttribute("book", book);
			RequestDispatcher rd = req.getRequestDispatcher("bookform.jsp");
			rd.forward(req, resp);

		} else if (action != null && action.equals("update")) {
			bookId = Integer.parseInt(req.getParameter("bookId"));
			book = bookDao.showBookById(bookId);
			req.setAttribute("action", "update");
			req.setAttribute("book", book);
			RequestDispatcher rd = req.getRequestDispatcher("bookform.jsp");
			rd.forward(req, resp);

		} else if (action != null && action.equals("delete")) {
			bookId = Integer.parseInt(req.getParameter("bookId"));
			book = bookDao.showBookById(bookId);
			req.setAttribute("book", book);
			RequestDispatcher rd = req.getRequestDispatcher("confirm.jsp");
			rd.forward(req, resp);

		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		action = req.getParameter("action");
		session = req.getSession();
		if (action != null && action.equals("add")) {
			bookName = req.getParameter("bookName");
			bookPrice = Double.parseDouble(req.getParameter("bookPrice"));
			book = new Book(bookName, bookPrice);
			bookDao.addBook(book);
			resp.sendRedirect("bookurl?action=list");
		} else if (action != null && action.equals("update")) {
			bookName = req.getParameter("bookName");
			bookPrice = Double.parseDouble(req.getParameter("bookPrice"));
			bookId = Integer.parseInt(req.getParameter("bookId"));
			book = new Book(bookName, bookPrice);
			bookDao.updateBook(bookId, book);
			resp.sendRedirect("bookurl?action=list");
		}
		else if (action != null && action.equals("delete"))
		{
		
			bookId = Integer.parseInt(req.getParameter("bookId"));
			bookDao.deleteBook(bookId);
			resp.sendRedirect("bookurl?action=list");
	}

}
}
