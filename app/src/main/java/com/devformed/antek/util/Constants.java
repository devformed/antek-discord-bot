package com.devformed.antek.util;

import com.devformed.antek.util.i18n.Locales;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Locale;

/**
 * @author Anton Gorokh
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Constants {
	public static final Locale DEFAULT_LOCALE = Locales.ENGLISH;
}
