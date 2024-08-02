package com.devformed.antek.service;

import com.devformed.antek.util.Translatable;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Anton Gorokh
 */
@AllArgsConstructor
@Getter
public enum Messages implements Translatable {
	COMMAND__UNKNOWN(false),
	COMMAND__DEVELOPER__RESPONSE(true); // developer

	private final boolean tokenized;
}
