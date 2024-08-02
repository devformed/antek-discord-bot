package com.devformed.antek.util.i18n;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Locale;

/**
 * @author Anton Gorokh
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Locales {
	public static final Locale ENGLISH = Locale.forLanguageTag("en");
	public static final Locale RUSSIAN = Locale.forLanguageTag("ru");
}
