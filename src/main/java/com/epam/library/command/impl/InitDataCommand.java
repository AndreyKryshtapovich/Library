package com.epam.library.command.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.library.bean.Request;
import com.epam.library.bean.Response;
import com.epam.library.command.Command;
import com.epam.library.service.BookService;
import com.epam.library.service.ServiceFactory;
import com.epam.library.service.exception.ServiceException;

public class InitDataCommand implements Command {

	private final static String INIT_DATA = "Data was initialized.";
	private final static Logger Logger = LogManager.getLogger(InitDataCommand.class.getName());

	@Override
	public Response execute(Request request) {

		ServiceFactory factory = ServiceFactory.getInstance();
		BookService bookService = factory.getBookService();

		Response response = new Response();

		try {
			bookService.fillTheDB();
			response.setErrorStatus(false);
			response.setSimpleMessage(INIT_DATA);
		} catch (ServiceException e) {
			response.setErrorStatus(true);
			response.setErrorMessage(e.getMessage());
			Logger.error(e.getMessage());
		}

		return response;

	}

}
