package com.epam.library.command.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.library.bean.RenameRequest;
import com.epam.library.bean.Request;
import com.epam.library.bean.Response;
import com.epam.library.command.Command;
import com.epam.library.service.BookService;
import com.epam.library.service.ServiceFactory;
import com.epam.library.service.exception.ServiceException;

public class RenameBookCommand implements Command {

	private final static Logger Logger = LogManager.getLogger(RenameBookCommand.class.getName());
	private final static String updated = "row was updated.";

	@Override
	public Response execute(Request request) {
		RenameRequest renameRequest = null;
		if (request instanceof RenameRequest) {
			renameRequest = (RenameRequest) request;
		}

		ServiceFactory factory = ServiceFactory.getInstance();
		BookService bookService = factory.getBookService();

		Response response = new Response();

		try {
			bookService.rename(renameRequest.getOldTitle(), renameRequest.getNewTitle());
			response.setErrorStatus(false);
			response.setSimpleMessage(updated);
		} catch (ServiceException e) {
			response.setErrorStatus(true);
			response.setErrorMessage(e.getMessage());
			Logger.error(e.getMessage());
		}

		return response;
	}

}
