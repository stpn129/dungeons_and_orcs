package com.dungeonsandorcs.rlgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
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

public class DungeonGame extends ApplicationAdapter {

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

    public final static int MENU = 0;
    public final static int PREFERENCES = 1;
    public final static int APPLICATION = 2;
    public final static int ENDGAME = 3;

    @Override
    public void create() {
            batch = new SpriteBatch();
            animator = new Animator();

            animator.create();
            controller = new Controller(animator);
            controller.create();

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        controller.render();
        batch.end();

    }

    @Override
    public void dispose() {
        batch.dispose();
    }


    public void changeScreen(int screen){
        switch(screen){
            case MENU:
                if(menuScreen == null) menuScreen = new MenuScreen();
                this.setScreen(menuScreen);
                break;
            case PREFERENCES:
                if(preferencesScreen == null) preferencesScreen = new PreferencesScreen();
                this.setScreen(preferencesScreen);
                break;
            case APPLICATION:
                if(mainScreen == null) mainScreen = new MainScreen();
                this.setScreen(mainScreen);
                break;
            case ENDGAME:
                if(endScreen == null) endScreen = new EndScreen();
                this.setScreen(endScreen);
                break;
        }
    }

    private void setScreen(Screen screen) {
    }
}
