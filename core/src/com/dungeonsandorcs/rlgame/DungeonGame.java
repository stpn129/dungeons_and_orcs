package com.dungeonsandorcs.rlgame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dungeonsandorcs.rlgame.controllers.Controller;
import com.dungeonsandorcs.rlgame.objects.Animator;
import com.dungeonsandorcs.rlgame.objects.Player;
import com.dungeonsandorcs.rlgame.screens.EndScreen;
import com.dungeonsandorcs.rlgame.screens.LoadingScreen;
import com.dungeonsandorcs.rlgame.screens.MainScreen;
import com.dungeonsandorcs.rlgame.screens.MenuScreen;
import com.dungeonsandorcs.rlgame.screens.PreferencesScreen;

import static com.dungeonsandorcs.rlgame.DungeonGame.States.APPLICATION;
import static com.dungeonsandorcs.rlgame.DungeonGame.States.ENDGAME;
import static com.dungeonsandorcs.rlgame.DungeonGame.States.MENU;
import static com.dungeonsandorcs.rlgame.DungeonGame.States.PREFERENCES;

public class DungeonGame extends Game {

    private static final int FRAME_COLS = 4; // вертикаль
    private static final int FRAME_ROWS = 4; // горизонт

    private Player player;
    private Animator animator;
    private Controller controller;
    private OrthographicCamera camera;

    private SpriteBatch batch;

    private LoadingScreen loadingScreen;
    private PreferencesScreen preferencesScreen;
    private MenuScreen menuScreen;
    private MainScreen mainScreen;
    private EndScreen endScreen;


    States state;


    @Override
    public void create() {
        loadingScreen = new LoadingScreen(this);
        setScreen(loadingScreen);

        animator = new Animator();

        animator.create();
        controller = new Controller(animator);
        controller.create();

    }

    @Override
    public void render() {
       Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); //а без этого ничего нет;
        batch = new SpriteBatch();
        batch.begin();
        controller.render();
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    public void changeScreen(int screen) {
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
                if (mainScreen == null) mainScreen = new MainScreen(this);
                this.setScreen(mainScreen);
                break;
            case ENDGAME:
                if (endScreen == null)
                    endScreen = new EndScreen(this);//тут я по логике this поставил
                this.setScreen(endScreen);
                break;
        }
    }


    public static enum States{
        MENU,PREFERENCES,APPLICATION,ENDGAME
    }
}
