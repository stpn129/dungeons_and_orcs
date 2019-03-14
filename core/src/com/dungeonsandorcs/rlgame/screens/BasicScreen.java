package com.dungeonsandorcs.rlgame.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.dungeonsandorcs.rlgame.DungeonGame;

class BasicScreen implements Screen {
    DungeonGame game;

    public BasicScreen(DungeonGame game) {
        this.game = game;

    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
    public void setScreen(DungeonGame.States state){
        game.changeScreen(state);
    }
}
