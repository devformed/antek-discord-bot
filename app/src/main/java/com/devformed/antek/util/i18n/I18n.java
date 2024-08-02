package com.devformed.antek.util.i18n;

import com.devformed.antek.util.Streams;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.io.Resources;
import jakarta.annotation.Nullable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.function.Function;
import java.util.logging.Level;

/**
 * @author Anton Gorokh
 */
@Log
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class I18n {

	public static final ImmutableSet<Locale> SUPPORTED_LOCALES = ImmutableSet.of(
			Locales.ENGLISH,
			Locales.RUSSIAN
	);
	private static final ImmutableMap<Locale, ResourceBundle> BUNDLE_BY_LOCALE;

	static {
		BUNDLE_BY_LOCALE = SUPPORTED_LOCALES.stream()
				.collect(Streams.immutableMapCollector(Function.identity(), I18n::getBundle));
	}

	public static String translate(String key, Map<String, String> placeHolders, Locale locale) {
		return Optional.ofNullable(BUNDLE_BY_LOCALE.get(locale))
				.filter(bundle -> bundle.containsKey(key))
				.map(bundle -> bundle.getString(key))
				.map(translation -> applyPlaceholders(translation, placeHolders))
				.orElse("!" + key + "!");
	}

	public static String translate(String key, Locale locale) {
		return translate(key, Collections.emptyMap(), locale);
	}

	private static String applyPlaceholders(String translation, Map<String, String> placeHolders) {
		for (Map.Entry<String, String> entry : placeHolders.entrySet()) {
			translation = translation.replaceAll("{%s}".formatted(entry.getKey()), entry.getValue());
		}
		return translation;
	}

	private static @Nullable ResourceBundle getBundle(Locale locale) {
		try {
			URL resource = Resources.getResource("i18n/translations_" + locale.getLanguage() + ".properties");
			ByteArrayInputStream resourceIS = new ByteArrayInputStream(Resources.toByteArray(resource));
			return new PropertyResourceBundle(resourceIS);
		} catch (IOException e) {
			log.log(Level.SEVERE, "Failed to load bundle for locale $locale", e);
			return null;
		}
	}
}
