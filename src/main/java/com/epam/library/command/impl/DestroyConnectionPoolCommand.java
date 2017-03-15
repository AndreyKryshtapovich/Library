package com.epam.library.command.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.library.service.InitOperationService;
import com.epam.library.service.ServiceFactory;
import com.epam.library.service.exception.ServiceException;

public class DestroyConnectionPoolCommand {
	private final static Logger Logger = LogManager.getLogger(DestroyConnectionPoolCommand.class.getName());

	public void execute() {
		ServiceFactory factory = ServiceFactory.getInstance();
		InitOperationService initService = factory.getInitOperationService();

		try {
			initService.destroyConnectionPoolData();
			Logger.info("Source was destroyed.");
		} catch (ServiceException e) {
			Logger.error(e);
		}
	}

}
