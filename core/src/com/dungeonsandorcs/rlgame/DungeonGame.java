package com.dungeonsandorcs.rlgame;

import com.badlogic.gdx.Game;
import com.dungeonsandorcs.rlgame.loader.B2dAssetManager;
import com.dungeonsandorcs.rlgame.screens.EndScreen;
import com.dungeonsandorcs.rlgame.screens.GameScreen;
import com.dungeonsandorcs.rlgame.screens.LoadingScreen;
import com.dungeonsandorcs.rlgame.screens.MainScreen;
import com.dungeonsandorcs.rlgame.screens.MenuScreen;
import com.dungeonsandorcs.rlgame.screens.PreferencesScreen;

public class DungeonGame extends Game {


    private PreferencesScreen preferencesScreen;
    private MenuScreen menuScreen;
    private GameScreen gameScreen;
    private EndScreen endScreen;
    private LoadingScreen loadingScreen;
    public B2dAssetManager assMan = new B2dAssetManager();


    public void changeScreen(States state) {
        System.out.println(state);
        switch (state) {
            case MENU:
                if (menuScreen == null) menuScreen = new MenuScreen(this);
                this.setScreen(menuScreen);
                break;
            case PREFERENCES:
                if (preferencesScreen == null) preferencesScreen = new PreferencesScreen(this);
                this.setScreen(preferencesScreen);
                break;
            case APPLICATION:
                if (gameScreen == null) gameScreen = new GameScreen(this);
                this.setScreen(gameScreen);
                break;
            case ENDGAME:
                if (endScreen == null)
                    endScreen = new EndScreen(this);//тут я по логике this поставил
                this.setScreen(endScreen);
                break;
            case LOADING:
                if (loadingScreen == null)
                    loadingScreen = new LoadingScreen(this);
                this.setScreen(loadingScreen);

        }
    }

    @Override
    public void create() {
        changeScreen(States.LOADING);
    }


    public enum States {
        MENU, PREFERENCES, APPLICATION, ENDGAME, LOADING
    }
}
