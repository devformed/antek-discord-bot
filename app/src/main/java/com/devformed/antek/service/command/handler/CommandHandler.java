package com.devformed.antek.service.command.handler;

import com.devformed.antek.service.command.Command;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

import java.util.Locale;

/**
 * @author Anton Gorokh
 */
public interface CommandHandler {

	void handle(SlashCommandInteractionEvent event, Locale locale);

	Command supported();
}
