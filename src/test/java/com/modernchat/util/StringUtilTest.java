package com.modernchat.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class StringUtilTest {

    @Test
    public void sanitizePlayerNameRemovesTagsAndSuffixes() {
        assertEquals("Some_Player", StringUtil.sanitizePlayerName("<img=2>Some Player (level-126)"));
    }

    @Test
    public void sanitizePlayerNameRemovesLeadingRankPrefixes() {
        assertEquals("Some_Player", StringUtil.sanitizePlayerName("[General] [Iron] Some Player"));
    }

    @Test
    public void sanitizeDisplayNameRemovesOnlyTags() {
        assertEquals("[General] Some Player", StringUtil.sanitizeDisplayName("<col=ff0000>[General] Some Player</col>"));
    }

    @Test
    public void sanitizePlayerNameReturnsNullForEmptyNames() {
        assertNull(StringUtil.sanitizePlayerName("<img=1>   "));
    }
}