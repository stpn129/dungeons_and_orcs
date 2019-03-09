package com.dungeonsandorcs.rlgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dungeonsandorcs.rlgame.controllers.Controller;
import com.dungeonsandorcs.rlgame.objects.Animator;
import com.dungeonsandorcs.rlgame.objects.Player;

public class DungeonGame extends ApplicationAdapter {

    private static final int FRAME_COLS = 4; // вертикаль
    private static final int FRAME_ROWS = 4; // горизонт

    private Player player;
    private Animator animator;
    private Controller controller;
    private OrthographicCamera camera;

    private SpriteBatch batch;

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
}
