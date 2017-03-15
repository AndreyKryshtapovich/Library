package com.epam.library.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.library.dao.DAOFactory;
import com.epam.library.dao.SourceInit;
import com.epam.library.dao.exception.DAOException;
import com.epam.library.service.InitOperationService;
import com.epam.library.service.exception.ServiceException;

/**
 * This class is the implementation of the
 * {@link com.epam.library.service.InitOperationService} for working with
 * database.
 * 
 * @author Andrey Kryshtapovich
 *
 */

public class InitOperation implements InitOperationService {
	private final static Logger Logger = LogManager.getLogger(InitOperation.class.getName());

	@Override
	public void initConnectionPoolData() throws ServiceException {
		DAOFactory factory = DAOFactory.getInstance();
		SourceInit initDAO = factory.getSourceInitDAO();

		try {
			initDAO.init();
		} catch (DAOException e) {
			Logger.error(e);
			throw new ServiceException("Failed initialization.", e);
		}
	}

	@Override
	public void destroyConnectionPoolData() throws ServiceException {
		DAOFactory factory = DAOFactory.getInstance();
		SourceInit initDAO = factory.getSourceInitDAO();

		try {
			initDAO.destroy();
		} catch (DAOException e) {
			Logger.error(e);
			throw new ServiceException("Failed destroying.", e);
		}
	}

}
