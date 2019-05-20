package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.mygdx.game.screens.GameScreen;
import com.mygdx.game.screens.LoadingScreen;
import com.mygdx.game.screens.MenuScreen;

public class MyGdxGame extends Game {
    private LoadingScreen loadingScreen;
    private MenuScreen menuScreen;
    private GameScreen gameScreen;

    @Override
    public void create() {
        changeScreen(AppConstants.LOADING);
    }

    public void changeScreen(int screenId) {
        System.out.println(screenId);
        switch (screenId) {
            case AppConstants.LOADING:
                if (loadingScreen == null)
                    loadingScreen = new LoadingScreen(this);
                setScreen(loadingScreen);
                break;
            case AppConstants.MENU:
                if (menuScreen == null)
                    menuScreen = new MenuScreen(this);
                setScreen(menuScreen);
                break;
            case AppConstants.GAME:
                if (gameScreen == null)
                    gameScreen = new GameScreen(this);
                setScreen(gameScreen);
                break;
        }
    }
}
