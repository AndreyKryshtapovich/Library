package com.epam.library.dao;

import com.epam.library.dao.impl.BookCounterDBDAO;
import com.epam.library.dao.impl.DBInitDAO;
import com.epam.library.dao.impl.EmployeeDBDAO;

/**
 * This class is designed to represent a factory for obtaining DAO objects. DAO
 * objects are implementations of DAO interfaces.
 * 
 * @author Andrey Kryshtapovich
 *
 */
public class DAOFactory {
	private static final DAOFactory INSTANCE = new DAOFactory();

	private BookDAO bookDAO = new BookCounterDBDAO();
	private SourceInit initDAO = new DBInitDAO();
	private EmployeeDAO employeeDAO = new EmployeeDBDAO();

	private DAOFactory() {
	}

	public static DAOFactory getInstance() {
		return INSTANCE;
	}

	/**
	 * 
	 * @return {@link com.epam.library.dao.BookDAO } object.
	 */
	public BookDAO getBookDAO() {
		return bookDAO;
	}

	public SourceInit getSourceInitDAO() {
		return initDAO;
	}

	public EmployeeDAO getEmployeeDAO() {
		return employeeDAO;
	}

}
