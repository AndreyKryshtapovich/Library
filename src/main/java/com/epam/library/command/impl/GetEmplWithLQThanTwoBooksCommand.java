package com.epam.library.command.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.library.bean.ReportLineLQThanTwoBooks;
import com.epam.library.bean.Request;
import com.epam.library.bean.Response;
import com.epam.library.command.Command;
import com.epam.library.service.EmployeeService;
import com.epam.library.service.ServiceFactory;
import com.epam.library.service.exception.ServiceException;

public class GetEmplWithLQThanTwoBooksCommand implements Command {
	private final static Logger Logger = LogManager.getLogger(GetEmplWithLQThanTwoBooksCommand.class.getName());

	@Override
	public Response execute(Request request) {
		List<ReportLineLQThanTwoBooks> report = new ArrayList<>();
		ServiceFactory factory = ServiceFactory.getInstance();
		EmployeeService employeeService = factory.getEmployeeService();

		Response response = new Response();

		try {
			report = employeeService.getEmplWithLQThanTwoBooks();
			response.setErrorStatus(false);
			response.setReportEmplWithLQThanTwoBooks(report);

		} catch (ServiceException e) {
			response.setErrorStatus(true);
			response.setErrorMessage(e.getMessage());
			Logger.error(e.getMessage());
		}

		return response;
	}

}
