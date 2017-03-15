package com.epam.library.controller;

import java.util.HashMap;
import java.util.Map;

import com.epam.library.command.Command;
import com.epam.library.command.CommandName;
import com.epam.library.command.impl.AddBookCommand;
import com.epam.library.command.impl.DeleteBookByTitleCommand;
import com.epam.library.command.impl.GetBookByTitleCommand;
import com.epam.library.command.impl.GetEmplWithGThanOneBookCommand;
import com.epam.library.command.impl.GetEmplWithLQThanTwoBooksCommand;
import com.epam.library.command.impl.InitDataCommand;
import com.epam.library.command.impl.RenameBookCommand;

class CommandProvider {
	private Map<CommandName, Command> commands = new HashMap<CommandName, Command>();

	CommandProvider() {
		commands.put(CommandName.ADD_BOOK, new AddBookCommand());
		commands.put(CommandName.DELETE_BOOK_BY_TITLE, new DeleteBookByTitleCommand());
		commands.put(CommandName.GET_BOOK_BY_TITLE, new GetBookByTitleCommand());
		commands.put(CommandName.RENAME, new RenameBookCommand());
		commands.put(CommandName.GET_EMPL_WITH_G_THAT_ONE_BOOK, new GetEmplWithGThanOneBookCommand());
		commands.put(CommandName.GET_EMPL_WITH_LQ_THAT_TWO_BOOKS, new GetEmplWithLQThanTwoBooksCommand());
		commands.put(CommandName.INIT_DATA, new InitDataCommand());

	}

	public Command getCommand(CommandName commandName) {
		Command command;
		command = commands.get(commandName);
		return command;
	}

}
