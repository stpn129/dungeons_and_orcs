package com.dungeonsandorcs.rlgame.screens;

import com.dungeonsandorcs.rlgame.DungeonGame;
import com.dungeonsandorcs.rlgame.utils.Objects;

public abstract class ObjectsScreen extends BasicScreen {
    ObjectsScreen(DungeonGame game) {
        super(game);
        Objects.create();
    }

    @Override
    public void dispose() {
        Objects.dispose();
    }
}
