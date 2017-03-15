package com.epam.library.service;

import java.util.List;

import com.epam.library.bean.ReportLineGThanOneBook;
import com.epam.library.bean.ReportLineLQThanTwoBooks;
import com.epam.library.service.exception.ServiceException;

public interface EmployeeService {
	List<ReportLineGThanOneBook> getEmplWithGThanOneBook() throws ServiceException;
	List<ReportLineLQThanTwoBooks> getEmplWithLQThanTwoBooks() throws ServiceException;

}
