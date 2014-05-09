package com.mintytech.microlite20charactergeneratorii.app.dummy;

import com.activeandroid.query.Select;
import com.mintytech.microlite20charactergeneratorii.app.PlayerCharacter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static List<PlayerCharacter> ITEMS = new ArrayList<PlayerCharacter>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<Long, PlayerCharacter> ITEM_MAP = new HashMap<Long, PlayerCharacter>();

    static {
        List<PlayerCharacter> characters = new Select().from(PlayerCharacter.class).execute();
        for(PlayerCharacter character:characters){
            addItem(character);
        }
    }

    public static void addItem(PlayerCharacter item) {

        ITEMS.add(item);
        ITEM_MAP.put(item.getId(), item);
    }
}
