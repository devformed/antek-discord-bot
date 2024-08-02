package com.devformed.antek.service.command.handler;

import com.devformed.antek.config.BotConfig;
import com.devformed.antek.service.Messages;
import com.devformed.antek.service.command.Command;
import com.devformed.antek.util.Users;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * @author Anton Gorokh
 */
@Component
public class DeveloperCommandHandler implements CommandHandler {

	private final BotConfig config;

	@Autowired
	public DeveloperCommandHandler(BotConfig config) {
		this.config = config;
	}

	@Override
	public Command supported() {
		return Command.DEVELOPER;
	}

	@Override
	public void handle(SlashCommandInteractionEvent event, Locale locale) {
		event.reply(Messages.COMMAND__DEVELOPER__RESPONSE.translate(locale, "developer", Users.ping(config.authorId())))
				.queue();
	}
}