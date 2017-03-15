package com.epam.library.service.impl;

import java.util.List;

import com.epam.library.dao.BookDAO;
import com.epam.library.dao.DAOFactory;
import com.epam.library.dao.exception.DAOException;
import com.epam.library.domain.Book;
import com.epam.library.domain.dto.BookDTO;
import com.epam.library.service.BookService;
import com.epam.library.service.exception.ServiceException;

public class BookCounterGeneralService implements BookService {

	@Override
	public void add(BookDTO bookDTO) throws ServiceException {
		if (!Validator.addValidation(bookDTO)) {
			throw new ServiceException("Invalid parameters.");
		}
		Book book = new Book();
		book.setAuthor(bookDTO.getAuthor());
		book.setBrief(bookDTO.getBrief());
		book.setPublishYear(new Integer(bookDTO.getPublishYear()));
		book.setTitle(bookDTO.getTitle());

		DAOFactory factory = DAOFactory.getInstance();
		BookDAO bookDao = factory.getBookDAO();

		try {
			bookDao.add(book);
		} catch (DAOException e) {
			throw new ServiceException("Failed adding a book.", e);
		}

	}

	@Override
	public List<Book> getByTitle(String title) throws ServiceException {
		if (!Validator.getValidation(title)) {
			throw new ServiceException("Invalid parameters");
		}

		DAOFactory factory = DAOFactory.getInstance();
		BookDAO bookDao = factory.getBookDAO();
		List<Book> bookList = null;
		try {
			bookList = bookDao.getByTitle(title);
		} catch (DAOException e) {
			throw new ServiceException("Failed data obtaining.", e);
		}

		return bookList;
	}

	@Override
	public void rename(String oldTitle, String newTitle) throws ServiceException {
		if (!Validator.renameValidation(oldTitle, newTitle)) {
			throw new ServiceException("Invalid parameters");
		}

		DAOFactory factory = DAOFactory.getInstance();
		BookDAO bookDao = factory.getBookDAO();

		try {
			bookDao.rename(oldTitle, newTitle);
		} catch (DAOException e) {
			throw new ServiceException("Failed renaming a book", e);
		}

	}

	@Override
	public void deleteByTitle(String title) throws ServiceException {
		if (!Validator.deleteValidation(title)) {
			throw new ServiceException("Invalid parameters");
		}

		DAOFactory factory = DAOFactory.getInstance();
		BookDAO bookDao = factory.getBookDAO();

		try {
			bookDao.deleteByTitle(title);
		} catch (DAOException e) {
			throw new ServiceException("Failed deletting a product", e);
		}

	}

	@Override
	public void fillTheDB() throws ServiceException {

		DAOFactory factory = DAOFactory.getInstance();
		BookDAO bookDAO = factory.getBookDAO();

		try {
			bookDAO.fillTheDB();
		} catch (DAOException e) {
			throw new ServiceException("Failed inserting data into the DB.", e);
		}
	}

}
