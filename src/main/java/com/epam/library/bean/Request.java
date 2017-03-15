package com.epam.library.bean;

import java.io.Serializable;

import com.epam.library.command.CommandName;

public class Request implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private CommandName commandName;
	
	public Request(){
		
	}

	public CommandName getCommandName() {
		return commandName;
	}

	public void setCommandName(CommandName commandName) {
		this.commandName = commandName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commandName == null) ? 0 : commandName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Request other = (Request) obj;
		if (commandName != other.commandName)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Request [commandName=" + commandName + "]";
	}
	
	

}
