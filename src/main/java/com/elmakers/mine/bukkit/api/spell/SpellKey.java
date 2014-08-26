package com.elmakers.mine.bukkit.api.spell;

import org.apache.commons.lang.StringUtils;

public class SpellKey {
    private final String key;
    private final String baseKey;
    private final int level;
    private final boolean isVariant;

    public SpellKey(String key) {
        this.key = key;
        if (key.contains("|")) {
            String[] pieces = StringUtils.split(key, "|");
            this.baseKey = pieces[0];
            int parsedLevel;
            try {
                parsedLevel = Integer.parseInt(pieces[1]);
            } catch (Exception ex) {
                parsedLevel = 1;
                ex.printStackTrace();
            }
            level = parsedLevel;
            isVariant = true;
        } else {
            level = 1;
            this.baseKey = key;
            isVariant = false;
        }
    }

    public String getKey() {
        return key;
    }

    public String getBaseKey() {
        return baseKey;
    }

    public int getLevel() {
        return level;
    }

    public boolean isVariant() {
        return isVariant;
    }
}
