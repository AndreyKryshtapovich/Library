package com.epam.library.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.library.dao.SourceInit;
import com.epam.library.dao.connectionpool.ConnectionPool;
import com.epam.library.dao.connectionpool.exception.ConnectionPoolException;
import com.epam.library.dao.exception.DAOException;

/**
 * This class is the implementation of the
 * {@link com.epam.library.dao.SourceInit} for working with database.
 * 
 * @author Andrey Kryshtapovich
 *
 */
public class DBInitDAO implements SourceInit {
	private final static Logger Logger = LogManager.getLogger(DBInitDAO.class.getName());

	@Override
	public void init() throws DAOException {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		try {
			connectionPool.initPoolData();
		} catch (ConnectionPoolException e) {
			Logger.error(e);
			throw new DAOException("Failed connection pool initialization.", e);
		}

	}

	@Override
	public void destroy() throws DAOException {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		try {
			connectionPool.dispose();
		} catch (ConnectionPoolException e) {
			Logger.error(e);
			throw new DAOException("Failed connection pool destroying", e);
		}

	}

}
