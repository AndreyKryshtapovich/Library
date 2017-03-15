package com.epam.library.command.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.library.bean.GetBookByTitleRequest;
import com.epam.library.bean.Request;
import com.epam.library.bean.Response;
import com.epam.library.command.Command;
import com.epam.library.domain.Book;
import com.epam.library.service.BookService;
import com.epam.library.service.ServiceFactory;
import com.epam.library.service.exception.ServiceException;

public class GetBookByTitleCommand implements Command {
	private final static Logger Logger = LogManager.getLogger(GetBookByTitleCommand.class.getName());

	@Override
	public Response execute(Request request) {
		List<Book> bookList = null;
		GetBookByTitleRequest getBookByTitleRequest = null;
		if (request instanceof GetBookByTitleRequest) {
			getBookByTitleRequest = (GetBookByTitleRequest) request;
		}

		Response response = new Response();

		ServiceFactory factory = ServiceFactory.getInstance();
		BookService bookService = factory.getBookService();

		try {
			bookList = bookService.getByTitle(getBookByTitleRequest.getTargetTitle());
			response.setErrorStatus(false);
			response.setBookList(bookList);
		} catch (ServiceException e) {
			response.setErrorStatus(true);
			response.setErrorMessage(e.getMessage());
			Logger.error(e.getMessage());
		}

		return response;
	}

}
