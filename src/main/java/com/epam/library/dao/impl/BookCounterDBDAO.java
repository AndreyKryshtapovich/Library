package com.epam.library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.library.dao.BookDAO;
import com.epam.library.dao.connectionpool.ConnectionPool;
import com.epam.library.dao.connectionpool.exception.ConnectionPoolException;
import com.epam.library.dao.exception.DAOException;
import com.epam.library.domain.Book;

public class BookCounterDBDAO implements BookDAO {
	private final static Logger Logger = LogManager.getLogger(BookCounterDBDAO.class.getName());

	private final static String COLUMN_AUTHOR = "author";
	private final static String COLUMN_BRIEF = "brief";
	private final static String COLUMN_PUBLISH_YEAR = "publish_year";
	private final static String COLUMN_TITLE = "title";

	private final static String INSERT_NEW_BOOK = "INSERT INTO `books_counter`.`book` (`brief`, `publish_year`, `author`,`title`) VALUES (?, ?, ?, ?);";
	private final static String GET_BOOK_BY_TITLE = "SELECT  `book`.`brief`, `book`.`publish_year`, `book`.`author`, `book`.`title` FROM `books_counter`.`book` WHERE `book`.`title` = ? ;";
	private final static String DELETE_BOOK_BY_TITLE = "DELETE FROM `books_counter`.`book` WHERE `books_counter`.`book`.title = ?;";
	private final static String RENAME_BY_TITLE = "UPDATE `books_counter`.`book` SET `title` = ? WHERE `title` = ?;";
	private final static String FILL_THE_DB = "INSERT INTO `books_counter`.`employee_book` (`book_id`, `employee_id`, `id`) VALUES (?, ?, ?);";
	private final static int MAX_NUMBER_OF_BOOKS = 52;
	private final static int MAX_NUMBER_OF_EMPLOYEES = 12;

	@Override
	public void add(Book book) throws DAOException {
		Connection con = null;
		PreparedStatement ps = null;
		ConnectionPool connectionPool = ConnectionPool.getInstance();

		try {
			con = connectionPool.takeConnection();
		} catch (ConnectionPoolException e) {
			throw new DAOException("Connection failed.", e);
		}

		try {
			ps = con.prepareStatement(INSERT_NEW_BOOK);
			ps.setString(1, book.getBrief());
			ps.setInt(2, book.getPublishYear());
			ps.setString(3, book.getAuthor());
			ps.setString(4, book.getTitle());

			ps.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException("Database access error. Failed creation new book.", e);
		} finally {
			connectionPool.closeConnection(con);
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					Logger.error(e);
				}
			}
		}

	}

	@Override
	public List<Book> getByTitle(String title) throws DAOException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		List<Book> bookList = new ArrayList<>();

		try {
			con = connectionPool.takeConnection();
		} catch (ConnectionPoolException e) {
			throw new DAOException("Connection failed.", e);
		}

		try {
			ps = con.prepareStatement(GET_BOOK_BY_TITLE);
			ps.setString(1, title);
			rs = ps.executeQuery();

			while (rs.next()) {
				Book book = new Book();
				book.setAuthor(rs.getString(COLUMN_AUTHOR));
				book.setBrief(COLUMN_BRIEF);
				book.setPublishYear(new Integer(rs.getString(COLUMN_PUBLISH_YEAR)));
				book.setTitle(COLUMN_TITLE);

				bookList.add(book);
			}

		} catch (SQLException e) {
			throw new DAOException("Failed data obtaining.", e);
		} finally {
			connectionPool.closeConnection(con);

			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					Logger.error(e);
				}
			}

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					Logger.error(e);
				}
			}

		}

		return bookList;
	}

	@Override
	public void rename(String oldTitle, String newTitle) throws DAOException {
		Connection con = null;
		PreparedStatement ps = null;
		ConnectionPool connectionPool = ConnectionPool.getInstance();

		try {
			con = connectionPool.takeConnection();
		} catch (ConnectionPoolException e) {
			throw new DAOException("Connection failed.", e);
		}

		try {
			ps = con.prepareStatement(RENAME_BY_TITLE);
			ps.setString(1, newTitle);
			ps.setString(2, oldTitle);
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException("Failed renaming a book.", e);
		} finally {
			connectionPool.closeConnection(con);

			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					Logger.error(e);
				}
			}
		}

	}

	@Override
	public void deleteByTitle(String title) throws DAOException {
		Connection con = null;
		PreparedStatement ps = null;
		ConnectionPool connectionPool = ConnectionPool.getInstance();

		try {
			con = connectionPool.takeConnection();
		} catch (ConnectionPoolException e) {
			throw new DAOException("Connection failed.", e);
		}

		try {

			ps = con.prepareStatement(DELETE_BOOK_BY_TITLE);
			ps.setString(1, title);
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException("Failed deletting a book.", e);
		} finally {

			connectionPool.closeConnection(con);

			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					Logger.error(e);
				}
			}

		}

	}

	/**
	 * Method should be called only once and only if there are no values in the employee_book table.
	 */
	@Override
	public void fillTheDB() throws DAOException {
		Connection con = null;
		PreparedStatement ps = null;
		ConnectionPool connectionPool = ConnectionPool.getInstance();

		class Node {
			int bookId;
			int employeeId;

			@SuppressWarnings("unused")
			public Node() {

			}

			public Node(int bookId, int employeeId) {
				this.bookId = bookId;
				this.employeeId = employeeId;
			}

			@SuppressWarnings("unused")
			public int getBookId() {
				return bookId;
			}

			@SuppressWarnings("unused")
			public void setBookId(int bookId) {
				this.bookId = bookId;
			}

			@SuppressWarnings("unused")
			public int getEmployeeId() {
				return employeeId;
			}

			@SuppressWarnings("unused")
			public void setEmployeeId(int employeeId) {
				this.employeeId = employeeId;
			}

			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + bookId;
				result = prime * result + employeeId;
				return result;
			}

			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				Node other = (Node) obj;
				if (bookId != other.bookId)
					return false;
				if (employeeId != other.employeeId)
					return false;
				return true;
			}

			@Override
			public String toString() {
				return "Node [bookId=" + bookId + ", employeeId=" + employeeId + "]";
			}

		}

		try {
			con = connectionPool.takeConnection();
		} catch (ConnectionPoolException e) {
			throw new DAOException("Connection failed.", e);
		}

		Set<Node> nodes = new HashSet<>();

		// Falues from the DB to provide unique combinations
		nodes.add(new Node(2, 2));
		nodes.add(new Node(7, 2));
		nodes.add(new Node(9, 2));
		nodes.add(new Node(13, 2));
		nodes.add(new Node(20, 12));

		try {
			ps = con.prepareStatement(FILL_THE_DB);
			Random rand = new Random();

			for (int i = 6; i < 150; i++) {
				int nextBookId = rand.nextInt(MAX_NUMBER_OF_BOOKS);
				int nextEmployeeId = rand.nextInt(MAX_NUMBER_OF_EMPLOYEES);
				boolean flag = true;

				do {

					while ((nextBookId == 0 | nextEmployeeId == 0)) {
						nextBookId = rand.nextInt(MAX_NUMBER_OF_BOOKS);
						nextEmployeeId = rand.nextInt(MAX_NUMBER_OF_EMPLOYEES);

					}

					if (!nodes.add(new Node(nextBookId, nextEmployeeId))) {
						nextBookId = 0;
						nextEmployeeId = 0;
						flag = false;
					} else {
						flag = true;
					}

				} while (flag == false);

				ps.setInt(1, nextBookId);
				ps.setInt(2, nextEmployeeId);
				ps.setInt(3, i);

				ps.executeUpdate();
			}
		} catch (SQLException e) {
			throw new DAOException("Failed to fill the DB.", e);
		} finally {

			connectionPool.closeConnection(con);

			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					Logger.error(e);
				}
			}

		}

	}

}
