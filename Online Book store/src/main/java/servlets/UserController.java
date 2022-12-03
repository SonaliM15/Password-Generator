package servlets;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import pojo.User;

@WebServlet("/userurl")
public class UserController extends HttpServlet {

	List<User> ulist = null;
	UserDao userDao = new UserDao();
	User user = new User();
	HttpSession session = null;
	String action, firstName, lastName, userEmail, userPassword, userRole, address, userQuestion, userAnswer;
	long userMobile;
	int userId;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		action = req.getParameter("action");
		session = req.getSession();
		if (action != null && action.equals("list")) {
			ulist = userDao.getAllUsers();
			session.setAttribute("ulist", ulist);
			resp.sendRedirect("userlist.jsp");

		} else if (action != null && action.equals("question")) {
			req.setAttribute("action", "question");
			RequestDispatcher rd = req.getRequestDispatcher("emailid.jsp");
			rd.forward(req, resp);

		} else if (action != null && action.equals("forgot")) {
			req.setAttribute("action", "forgot");
			RequestDispatcher rd = req.getRequestDispatcher("forgotpassword.jsp");
			rd.forward(req, resp);

		} else if (action != null && action.equals("updatepass")) {
			req.setAttribute("action", "updatepass");
			RequestDispatcher rd = req.getRequestDispatcher("changepassword.jsp");
			rd.forward(req, resp);

		} else if (action != null && action.equals("add")) {
			user = new User(0, "", "", "", 0, "", "", "", "", "");
			req.setAttribute("action", "add");
			req.setAttribute("user", user);
			RequestDispatcher rd = req.getRequestDispatcher("registration.jsp");
			rd.forward(req, resp);
		}

		else if (action != null && action.equals("update")) {
			userId = Integer.parseInt(req.getParameter("userId"));
			req.setAttribute("action", "update");
			user = userDao.showUserById(userId);
			req.setAttribute("user", user);
			RequestDispatcher rd = req.getRequestDispatcher("registration.jsp");
			rd.forward(req, resp);

		} else if (action != null && action.equals("delete")) {
			userId = Integer.parseInt(req.getParameter("userId"));
			req.setAttribute("action", "delete");
			user = userDao.showUserById(userId);
			req.setAttribute("user", user);
			RequestDispatcher rd = req.getRequestDispatcher("confirmation.jsp");
			rd.forward(req, resp);

		} else if (action != null && action.equals("login")) {
			req.setAttribute("action", "login");
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
		} else if (action != null && action.equals("logout")) {
			req.setAttribute("action", "logout");
			session.invalidate();
			session = req.getSession();
			resp.sendRedirect("login.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		action = req.getParameter("action");
		session = req.getSession();
		User session_user = (User) session.getAttribute("user");
		if (action != null && action.equals("add")) {
			firstName = req.getParameter("firstName");
			lastName = req.getParameter("lastName");
			userEmail = req.getParameter("userEmail");
			userRole = req.getParameter("userRole");
			userPassword = req.getParameter("userPassword");
			address = req.getParameter("address");
			userQuestion = req.getParameter("userQuestion");
			userAnswer = req.getParameter("userAnswer");
			userMobile = Long.parseLong(req.getParameter("userMobile"));
			user = new User(firstName, lastName, userEmail, userMobile, userPassword, userRole, address, userQuestion,
					userAnswer);
			userDao.addUser(user);

			if (session_user == null) {
				resp.sendRedirect("login.jsp");
			} else if (session_user.getUserRole().equals("Admin")) {
				resp.sendRedirect("userurl?action=list");
			}

		}

		else if (action != null && action.equals("update")) {
			firstName = req.getParameter("firstName");
			lastName = req.getParameter("lastName");
			userEmail = req.getParameter("userEmail");
			userRole = req.getParameter("userRole");
			userPassword = req.getParameter("userPassword");
			address = req.getParameter("address");
			userMobile = Long.parseLong(req.getParameter("userMobile"));
			userId = Integer.parseInt(req.getParameter("userId"));
			userQuestion = req.getParameter("userQuestion");
			userAnswer = req.getParameter("userAnswer");

			user = new User(firstName, lastName, userEmail, userMobile, userPassword, userRole, address, userQuestion,
					userAnswer);
			userDao.updateUser(userId, user);
			resp.sendRedirect("userurl?action=list");

		}

		else if (action != null && action.equals("delete")) {
			userId = Integer.parseInt(req.getParameter("userId"));
			userDao.deleteUser(userId);
			resp.sendRedirect("userurl?action=list");

		} else if (action != null && action.equals("login")) {
			userEmail = req.getParameter("userEmail");
			userPassword = req.getParameter("userPassword");
			user = userDao.loginUserName(userEmail, userPassword);
			if (user != null && user.getUserRole().equals("Admin")) {
				session.setAttribute("user", user);
				resp.sendRedirect("home.jsp");
			} else if (user != null && user.getUserRole().equals("Customer")) {
				session.setAttribute("user", user);
				resp.sendRedirect("cust_header.jsp");
			} else if (user == null) {
				session.setAttribute("msg", "Login failed..");
				resp.sendRedirect("login.jsp");

			}

		} else if (action != null && action.equals("question")) {
			userEmail = req.getParameter("userEmail");
			user = userDao.getQuestion(userEmail);
			if (user != null) {
				session.setAttribute("user", user);
				resp.sendRedirect("userurl?action=forgot");
			} else {
				session.setAttribute("msg", "Login failed..");
				resp.sendRedirect("emailid.jsp");
			}

		} else if (action != null && action.equals("forgot")) {
			userQuestion = req.getParameter("fpQuestion");
			userAnswer = req.getParameter("fpAnswer");
			user = userDao.forgotPassword(userQuestion, userAnswer);
			if (user != null) {
				session.setAttribute("user", user);
				resp.sendRedirect("userurl?action=updatepass");
			} else {
				
				session.setAttribute("msg", "Login failed..");
				resp.sendRedirect("login.jsp");
			}

		} else if (action != null && action.equals("updatepass")) {
			userEmail = req.getParameter("userEmail");
			userPassword = req.getParameter("userPassword");
			userDao.updatePass(userEmail, userPassword);
			session.invalidate();
			session = req.getSession();
			resp.sendRedirect("login.jsp");
		}

	}

}
