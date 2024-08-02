package com.devformed.antek.util;

import com.devformed.antek.util.i18n.I18n;

import java.util.Collections;
import java.util.Locale;
import java.util.logging.Logger;

/**
 * @author Anton Gorokh
 */
public interface Translatable {

	Logger log = Logger.getLogger(Translatable.class.getName());

	String name();

	boolean isTokenized();

	default String key() {
		return this.name().replaceAll("__", ".");
	}

	default String translate(Locale locale) {
		if (isTokenized()) {
			log.warning("translation %s is used without placeholders".formatted(this.key()));
		}
		return I18n.translate(this.key(), locale);
	}

	default String translate(Locale locale, String key, String value) {
		return I18n.translate(this.key(), Collections.singletonMap(key, value), locale);
	}
}
