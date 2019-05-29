package com.dungeonsandorcs.rlgame.screens;

import com.badlogic.gdx.ScreenAdapter;
import com.dungeonsandorcs.rlgame.DungeonGame;

abstract class BasicScreen extends ScreenAdapter {
    DungeonGame game;

    BasicScreen(DungeonGame game) {
        this.game = game;

    }

    void setScreen(DungeonGame.States state){
        game.changeScreen(state);
    }
}
