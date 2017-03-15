package com.epam.library.dao;

import java.util.List;

import com.epam.library.dao.exception.DAOException;
import com.epam.library.domain.Book;

public interface BookDAO {
	
	void add(Book book) throws DAOException;
	List<Book> getByTitle (String title) throws DAOException;
	void rename(String oldTitle, String newTitle) throws DAOException;
	void deleteByTitle(String title) throws DAOException;
	void fillTheDB() throws DAOException;
	
	
}
