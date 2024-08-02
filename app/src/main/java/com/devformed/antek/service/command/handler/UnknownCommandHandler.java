package com.devformed.antek.service.command.handler;

import com.devformed.antek.service.Messages;
import com.devformed.antek.service.command.Command;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * @author Anton Gorokh
 */
@Component
public class UnknownCommandHandler implements CommandHandler {

	@Override
	public Command supported() {
		return Command.UNKNOWN;
	}

	@Override
	public void handle(SlashCommandInteractionEvent event, Locale locale) {
		event.reply(Messages.COMMAND__UNKNOWN.translate(locale))
				.queue();
	}
}
