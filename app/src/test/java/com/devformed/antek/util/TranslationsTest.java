package com.devformed.antek.util;

import com.devformed.antek.service.Messages;
import com.devformed.antek.util.i18n.Locales;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.fail;

public class TranslationsTest {

    @Test
    public void translatable_en() {
        assertTranslationExists(Locales.ENGLISH, Messages.values());
    }

    @Test
    public void translatable_ru() {
        assertTranslationExists(Locales.RUSSIAN, Messages.values());
    }

    private static void assertTranslationExists(Locale locale, Translatable[]... translatableArray) {
        String missing = Arrays.stream(translatableArray)
                .flatMap(Arrays::stream)
                .map(translatable -> translatable.translate(locale))
                .filter(translation -> translation.matches("!.+!"))
                .map(miss -> miss.substring(1, miss.length() - 1))
                .collect(Collectors.joining("\n"));

        if (Strings.isNotBlank(missing)) {
            fail("Missing %s translations:\n%s".formatted(locale.getDisplayLanguage(), missing));
        }
    }
}
