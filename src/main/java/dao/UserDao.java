package dao;

import java.sql.*;
import java.util.*;

import pojo.User;

public class UserDao {

	Connection con = null;
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement ps = null;

	private Connection getCon() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/book";
			String user = "root";
			String pwd = "";
			con = DriverManager.getConnection(url, user, pwd);
			return con;

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		return null;

	}

	public void addUser(User user) {
		con = getCon();
		try {
			ps = con.prepareStatement(
					"insert into user (firstName, lastName, userEmail,userMobile, userPassword, userRole,  address, userQuestion, userAnswer) values (?,?,?,?,?,?,?,?,?)");
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getUserEmail());
			ps.setLong(4, user.getUserMobile());
			ps.setString(5, user.getUserPassword());
			ps.setString(6, user.getUserRole());
			ps.setString(7, user.getUserAddress());
			ps.setString(8, user.getUserQuestion());
			ps.setString(9, user.getUserAnswer());
			int row = ps.executeUpdate();
			System.out.println(row + " row/s inserted");

			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<User> getAllUsers() {
		con = getCon();
		List<User> nlist = new ArrayList<User>();
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from user");

			while (rs.next()) {
				User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getLong(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
				nlist.add(user);
			}
			rs.close();
			st.close();

			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return nlist;

	}

	public boolean deleteUser(int id) {

		con = getCon();
		try {
			ps = con.prepareStatement("delete from user where userId = ?");
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

	public boolean updateUser(int id, User user) {

		con = getCon();
		try {
			ps = con.prepareStatement(
					"update user set firstName=?, lastName=?, userEmail=?,userMobile=?, userPassword=?, userRole=?, address=?, userQuestion = ?, userAnswer= ?  where userId=?");
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getUserEmail());
			ps.setLong(4, user.getUserMobile());
			ps.setString(5, user.getUserPassword());
			ps.setString(6, user.getUserRole());
			ps.setString(7, user.getUserAddress());
			ps.setString(8, user.getUserQuestion());
			ps.setString(9, user.getUserAnswer());
			ps.setInt(10, id);

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

	public User showUserById(int id) {
		con = getCon();

		try {
			ps = con.prepareStatement("select * from user where userId=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getLong(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
				return user;
			}
			rs.close();
			ps.close();

			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;

	}

	public User loginUserName(String userName, String userPassword) {
		con = getCon();
		try {
			ps = con.prepareStatement("select * from user where userEmail=? and userPassword=?");
			ps.setString(1, userName);
			ps.setString(2, userPassword);

			rs = ps.executeQuery();

			if (rs.next()) {

				User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getLong(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public User loginUserMobile(Long userMobile, String userPassword) {
		con = getCon();
		try {
			ps = con.prepareStatement("select * from user where userMobile=? and userPassword=?");
			ps.setLong(1, userMobile);
			ps.setString(2, userPassword);

			rs = ps.executeQuery();

			if (rs.next()) {

				User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getLong(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public User getQuestion(String userEmail) {
		con = getCon();

		try {
			ps = con.prepareStatement("select * from user where userEmail=?");
			ps.setString(1, userEmail);

			rs = ps.executeQuery();

			while (rs.next()) {
				User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getLong(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
				return user;
			}
			rs.close();
			ps.close();

			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;

	}

	public User forgotPassword(String question, String answer) {
		con = getCon();

		try {
			ps = con.prepareStatement("select * from user where userQuestion=? and userAnswer=?");
			ps.setString(1, question);
			ps.setString(2, answer);
			rs = ps.executeQuery();

			while (rs.next()) {
				User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getLong(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
				return user;
			}
			rs.close();
			ps.close();

			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;

	}

	public boolean updatePass(String userEmail, String userPassword) {

		con = getCon();
		try {
			ps = con.prepareStatement("update user set  userPassword=? where  userEmail=?");
			ps.setString(1, userPassword);
			ps.setString(2, userEmail);

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

}
