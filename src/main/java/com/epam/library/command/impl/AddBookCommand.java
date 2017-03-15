package com.epam.library.command.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.library.bean.AddBookRequest;
import com.epam.library.bean.Request;
import com.epam.library.bean.Response;
import com.epam.library.command.Command;
import com.epam.library.domain.dto.BookDTO;
import com.epam.library.service.BookService;
import com.epam.library.service.ServiceFactory;
import com.epam.library.service.exception.ServiceException;

public class AddBookCommand implements Command {
	private final static String addRow = "Row added.";
	private final static Logger Logger = LogManager.getLogger(AddBookCommand.class.getName());

	@Override
	public Response execute(Request request) {
		AddBookRequest addBookRequest = null;
		if (request instanceof AddBookRequest) {
			addBookRequest = (AddBookRequest) request;
		}

		BookDTO bookDTO = new BookDTO();
		bookDTO.setAuthor(addBookRequest.getAuthor());
		bookDTO.setBrief(addBookRequest.getBrief());
		bookDTO.setPublishYear(addBookRequest.getPublishYear().toString());
		bookDTO.setTitle(addBookRequest.getTitle());

		ServiceFactory factory = ServiceFactory.getInstance();
		BookService bookService = factory.getBookService();

		Response response = new Response();
		try {
			bookService.add(bookDTO);
			response.setErrorStatus(false);
			response.setSimpleMessage(addRow);
		} catch (ServiceException e) {
			response.setErrorStatus(true);
			response.setErrorMessage(e.getMessage());
			Logger.error(e.getMessage());
		}

		return response;
	}

}
