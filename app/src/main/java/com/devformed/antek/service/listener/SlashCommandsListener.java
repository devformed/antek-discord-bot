package com.devformed.antek.service.listener;

import com.devformed.antek.service.command.Command;
import com.devformed.antek.service.command.handler.CommandHandler;
import com.devformed.antek.util.Constants;
import com.devformed.antek.util.Streams;
import com.google.common.collect.ImmutableMap;
import lombok.extern.java.Log;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

/**
 * @author Anton Gorokh
 */
@Log
@Component
public class SlashCommandsListener extends ListenerAdapter {

	private final ImmutableMap<String, CommandHandler> commandHandlers;
	private final CommandHandler unknownCommandHandler;

	@Autowired
	public SlashCommandsListener(Set<CommandHandler> commandHandlers) {
		this.commandHandlers = commandHandlers.stream()
				.collect(Streams.immutableMapCollector(command -> command.supported().commandName(), Function.identity()));
		this.unknownCommandHandler = Optional.ofNullable(this.commandHandlers.get(Command.UNKNOWN.commandName()))
				.orElseThrow(() -> new ExceptionInInitializerError("No unknown command handler provided"));
	}

	@Override
	public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
		Optional.ofNullable(commandHandlers.get(event.getName()))
				.orElse(unknownCommandHandler)
				.handle(event, Constants.DEFAULT_LOCALE);
	}
}
