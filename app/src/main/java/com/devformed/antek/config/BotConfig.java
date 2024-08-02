package com.devformed.antek.config;

import com.google.common.collect.ImmutableList;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Anton Gorokh
 */
@ConfigurationProperties("antek-bot")
public record BotConfig(
		String id,
		String authorId,
		String name,
		String token
) {

	public static final ImmutableList<GatewayIntent> INTENTS = ImmutableList.of(
			GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_VOICE_STATES
	);
}
