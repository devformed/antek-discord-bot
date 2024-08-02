package com.devformed.antek.service.command;

/**
 * @author Anton Gorokh
 */
public enum Command {
	DEVELOPER,
	UNKNOWN;

	public String commandName() {
		return this.name().toLowerCase().replaceAll("_", " ");
	}
}
