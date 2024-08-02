package com.devformed.antek.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.dv8tion.jda.api.entities.User;

/**
 * @author Anton Gorokh
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Users {

	public static String ping(String authorId) {
		return "<@" + authorId + ">";
	}

	public static String ping(User author) {
		return ping(author.getId());
	}
}
