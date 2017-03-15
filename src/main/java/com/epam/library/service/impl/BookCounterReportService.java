package com.epam.library.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.epam.library.bean.ReportLineGThanOneBook;
import com.epam.library.bean.ReportLineLQThanTwoBooks;
import com.epam.library.dao.DAOFactory;
import com.epam.library.dao.EmployeeDAO;
import com.epam.library.dao.exception.DAOException;
import com.epam.library.service.EmployeeService;
import com.epam.library.service.exception.ServiceException;

public class BookCounterReportService implements EmployeeService {

	@Override
	public List<ReportLineGThanOneBook> getEmplWithGThanOneBook() throws ServiceException {

		DAOFactory factory = DAOFactory.getInstance();
		EmployeeDAO employeeDao = factory.getEmployeeDAO();
		List<ReportLineGThanOneBook> report = new ArrayList<>();

		try {
			report = employeeDao.getEmplWithGThanOneBook();
		} catch (DAOException e) {
			throw new ServiceException("Failed adding a book.", e);
		}

		return report;
	}

	@Override
	public List<ReportLineLQThanTwoBooks> getEmplWithLQThanTwoBooks() throws ServiceException {
		DAOFactory factory = DAOFactory.getInstance();
		EmployeeDAO employeeDao = factory.getEmployeeDAO();
		List<ReportLineLQThanTwoBooks> report = new ArrayList<>();

		try {
			report = employeeDao.getEmplWithLQThanTwoBooks();
		} catch (DAOException e) {
			throw new ServiceException("Failed adding a book.", e);
		}

		return report;
	}

}
