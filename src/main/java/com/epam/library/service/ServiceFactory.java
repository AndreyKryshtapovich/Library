package com.epam.library.service;

import com.epam.library.service.impl.BookCounterGeneralService;
import com.epam.library.service.impl.BookCounterReportService;
import com.epam.library.service.impl.InitOperation;

public class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();

	private BookService bookService = new BookCounterGeneralService();
	private EmployeeService employeeService = new BookCounterReportService();
	private InitOperationService initService = new InitOperation();

	private ServiceFactory() {
	}

	public static ServiceFactory getInstance() {
		return instance;
	}

	public BookService getBookService() {
		return bookService;
	}

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public InitOperationService getInitOperationService() {
		return initService;
	}

}
