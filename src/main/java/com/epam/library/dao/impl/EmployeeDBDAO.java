package com.epam.library.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.library.bean.ReportLineGThanOneBook;
import com.epam.library.bean.ReportLineLQThanTwoBooks;
import com.epam.library.dao.EmployeeDAO;
import com.epam.library.dao.connectionpool.ConnectionPool;
import com.epam.library.dao.connectionpool.exception.ConnectionPoolException;
import com.epam.library.dao.exception.DAOException;

public class EmployeeDBDAO implements EmployeeDAO {

	private final static Logger Logger = LogManager.getLogger(EmployeeDBDAO.class.getName());

	private final static String GET_EMPLOYEES_WITH_G_THAN_ONE_BOOK = "SELECT  e.name as employee_name, q.book_count  FROM employee as e JOIN (SELECT eb.employee_id, COUNT(*) as book_count FROM employee_book as eb GROUP BY eb.employee_id HAVING book_count > 1) as q ON q.employee_id = e.id ORDER BY q.book_count; ";
	private final static String GET_EMPLOYEES_WITH_LQ_THAN_TWO_BOOKS = "SELECT e.`name` as employee_name, e.`date_of_birth`, e.`email`, COUNT(eb.book_id) as book_count  FROM `employee` AS e   LEFT JOIN `employee_book` AS eb ON eb.`employee_id` = e.`id`  GROUP BY eb.`employee_id` , e.`name`, e.`date_of_birth`, e.`email` HAVING COUNT(*)<=2 ORDER BY e.`date_of_birth`,book_count desc";
	private final static String EMPLOYEE_NAME_COLUMN = "employee_name";
	private final static String NUMBER_OF_BOOKS_COLUMN = "book_count";
	private final static String DATE_OF_BIRTH_COLUMN = "date_of_birth";

	@Override

	public List<ReportLineGThanOneBook> getEmplWithGThanOneBook() throws DAOException {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		List<ReportLineGThanOneBook> report = new ArrayList<>();

		try {
			con = connectionPool.takeConnection();
		} catch (ConnectionPoolException e) {
			throw new DAOException("Connection failed.", e);
		}

		try {
			st = con.createStatement();
			rs = st.executeQuery(GET_EMPLOYEES_WITH_G_THAN_ONE_BOOK);
			while (rs.next()) {
				ReportLineGThanOneBook line = new ReportLineGThanOneBook();
				line.setEmployeeName(rs.getString(EMPLOYEE_NAME_COLUMN));
				line.setNumberOfBooks(rs.getInt(NUMBER_OF_BOOKS_COLUMN));
				report.add(line);
			}
		} catch (SQLException e) {
			throw new DAOException("Failed data obtaining.", e);
		} finally {
			connectionPool.closeConnection(con);
			if (st != null) {
				try {
					st.close();
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

		return report;
	}

	@Override
	public List<ReportLineLQThanTwoBooks> getEmplWithLQThanTwoBooks() throws DAOException {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		List<ReportLineLQThanTwoBooks> report = new ArrayList<>();

		try {
			con = connectionPool.takeConnection();
		} catch (ConnectionPoolException e) {
			throw new DAOException("Connection failed.", e);
		}

		try {
			st = con.createStatement();
			rs = st.executeQuery(GET_EMPLOYEES_WITH_LQ_THAN_TWO_BOOKS);
			while (rs.next()) {
				ReportLineLQThanTwoBooks line = new ReportLineLQThanTwoBooks();
				line.setEmployeeName(rs.getString(EMPLOYEE_NAME_COLUMN));
				line.setEmplsDateOfBirth(rs.getDate(DATE_OF_BIRTH_COLUMN));
				line.setNumberOfBooks(rs.getInt(NUMBER_OF_BOOKS_COLUMN));
				report.add(line);
			}
		} catch (SQLException e) {
			throw new DAOException("Failed data obtaining.", e);
		} finally {
			connectionPool.closeConnection(con);
			if (st != null) {
				try {
					st.close();
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

		return report;
	}

}
