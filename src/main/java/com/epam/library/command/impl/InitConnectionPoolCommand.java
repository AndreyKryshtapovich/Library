package com.epam.library.command.impl;

import com.epam.library.service.InitOperationService;
import com.epam.library.service.ServiceFactory;
import com.epam.library.service.exception.ServiceException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InitConnectionPoolCommand {
	private final static Logger Logger = LogManager.getLogger(InitConnectionPoolCommand.class.getName());

	public void execute() {
		ServiceFactory factory = ServiceFactory.getInstance();
		InitOperationService initService = factory.getInitOperationService();

		try {
			initService.initConnectionPoolData();
			Logger.info("Source was initializad");
		} catch (ServiceException e) {
			Logger.error(e);
			throw new RuntimeException();
		}
	}

}
