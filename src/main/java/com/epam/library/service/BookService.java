package com.epam.library.service;

import java.util.List;

import com.epam.library.domain.Book;
import com.epam.library.domain.dto.BookDTO;
import com.epam.library.service.exception.ServiceException;

public interface BookService {
	void add(BookDTO bookDTO) throws ServiceException;
	List<Book> getByTitle (String title) throws ServiceException;
	void rename(String oldTitle, String newTitle) throws ServiceException;
	void deleteByTitle(String title) throws ServiceException;
	void fillTheDB() throws ServiceException;

}
