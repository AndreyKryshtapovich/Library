package com.epam.library.command.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.library.bean.DeleteBookRequest;
import com.epam.library.bean.Request;
import com.epam.library.bean.Response;
import com.epam.library.command.Command;
import com.epam.library.service.BookService;
import com.epam.library.service.ServiceFactory;
import com.epam.library.service.exception.ServiceException;

public class DeleteBookByTitleCommand implements Command {
	private final static String DELETE_ROW = "Row was deletted.";
	private final static Logger Logger = LogManager.getLogger(DeleteBookByTitleCommand.class.getName());

	@Override
	public Response execute(Request request) {

		DeleteBookRequest deleteBookRequest = null;
		if (request instanceof DeleteBookRequest) {
			deleteBookRequest = (DeleteBookRequest) request;
		}

		ServiceFactory factory = ServiceFactory.getInstance();
		BookService bookService = factory.getBookService();

		Response response = new Response();

		try {
			bookService.deleteByTitle(deleteBookRequest.getTargetTitle());
			response.setErrorStatus(false);
			response.setSimpleMessage(DELETE_ROW);
		} catch (ServiceException e) {
			response.setErrorStatus(false);
			response.setErrorMessage(e.getMessage());
			Logger.error(e.getMessage());
		}

		return response;
	}

}
