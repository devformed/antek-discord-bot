package com.devformed.antek;

import com.devformed.antek.config.BotConfig;
import com.devformed.antek.service.command.Command;
import com.google.common.collect.ImmutableList;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.EventListener;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

/**
 * @author Anton Gorokh
 */
@Service
public final class BotLauncher implements CommandLineRunner {

	private static final ImmutableList<CommandData> COMMANDS = ImmutableList.<CommandData>builder()
			.add(net.dv8tion.jda.api.interactions.commands.build.Commands.slash(Command.DEVELOPER.commandName(), "Provides information about bot creator"))
			.build();

	private final BotConfig config;
	private final EventListener[] eventListeners;

	@Autowired
	public BotLauncher(BotConfig config, EventListener[] eventListeners) {
		this.config = config;
		this.eventListeners = eventListeners;
	}

	@Override
	public void run(String... args) throws InterruptedException {
		JDA jda = JDABuilder.createDefault(config.token(), BotConfig.INTENTS)
				.addEventListeners((Object[]) eventListeners)
				.build()
				.awaitReady();

		jda.updateCommands()
				.addCommands(COMMANDS)
				.queue();
	}
}
