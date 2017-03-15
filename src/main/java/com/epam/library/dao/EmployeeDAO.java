package com.epam.library.dao;

import java.util.List;

import com.epam.library.bean.ReportLineGThanOneBook;
import com.epam.library.bean.ReportLineLQThanTwoBooks;
import com.epam.library.dao.exception.DAOException;

public interface EmployeeDAO {

	List<ReportLineGThanOneBook> getEmplWithGThanOneBook() throws DAOException;

	List<ReportLineLQThanTwoBooks> getEmplWithLQThanTwoBooks() throws DAOException;

}
