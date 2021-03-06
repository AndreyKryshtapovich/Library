package com.epam.library.dao;

import com.epam.library.dao.exception.DAOException;

/**
 * Interface contains methods required for initialization of the data source for
 * working with data storage.
 * 
 * @author Andrey Kryshtapovich
 *
 */
public interface SourceInit {

	/**
	 * Initializes the data source.
	 * 
	 * @throws DAOException
	 *             if initialization fails.
	 */

	void init() throws DAOException;

	/**
	 * Destroys the data source.
	 * 
	 * @throws DAOException
	 *             if destroying fails.
	 */
	void destroy() throws DAOException;

}
