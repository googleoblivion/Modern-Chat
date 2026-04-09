package com.modernchat.util;

import net.runelite.client.util.Text;

import java.util.regex.Pattern;

public class StringUtil {

    private static final Pattern LEADING_RANK_PREFIX = Pattern.compile("^(?:\\[[^\\]]+\\]\\s*)+");
    private static final Pattern TRAILING_PLAYER_SUFFIX = Pattern.compile("\\s+\\([^)]*\\)$");

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static String sanitizeDisplayName(String value) {
        if (value == null) {
            return null;
        }

        String cleaned = Text.removeTags(value).trim();
        return cleaned.isEmpty() ? null : cleaned;
    }

    public static String sanitizePlayerName(String value) {
        String cleaned = sanitizeDisplayName(value);
        if (cleaned == null) {
            return null;
        }

        cleaned = LEADING_RANK_PREFIX.matcher(cleaned).replaceFirst("");
        cleaned = TRAILING_PLAYER_SUFFIX.matcher(cleaned).replaceFirst("").trim();
        if (cleaned.isEmpty()) {
            return null;
        }

        String jagexName = Text.toJagexName(cleaned);
        return jagexName.isEmpty() ? null : jagexName;
    }
}
