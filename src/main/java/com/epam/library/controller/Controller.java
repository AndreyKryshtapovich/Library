package com.epam.library.controller;

import com.epam.library.bean.Request;
import com.epam.library.bean.Response;
import com.epam.library.command.Command;
import com.epam.library.command.CommandName;
import com.epam.library.command.impl.DestroyConnectionPoolCommand;
import com.epam.library.command.impl.InitConnectionPoolCommand;

public final class Controller {
	private final CommandProvider provider = new CommandProvider();

	public Controller() {
		InitConnectionPoolCommand command = new InitConnectionPoolCommand();
		command.execute();
	}

	public Response doAction(Request request) {

		CommandName commandName = request.getCommandName();
		Command command = provider.getCommand(commandName);
		Response response = command.execute(request);

		return response;
	}

	public void destroyConnectionResources() {
		DestroyConnectionPoolCommand command = new DestroyConnectionPoolCommand();
		command.execute();
	}

}
