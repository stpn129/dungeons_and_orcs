package com.dungeonsandorcs.rlgame.screens;

import com.dungeonsandorcs.rlgame.B2dContactListener;
import com.dungeonsandorcs.rlgame.DungeonGame;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.dungeonsandorcs.rlgame.controllers.KeyboardController;

import com.dungeonsandorcs.rlgame.systems.DebugSystem;
import com.dungeonsandorcs.rlgame.utils.BodyFactory;
import com.dungeonsandorcs.rlgame.utils.EntityUtils;
import com.dungeonsandorcs.rlgame.utils.Objects;

public class GameScreen extends BasicScreen {

    private OrthographicCamera cam;
    private KeyboardController controller;
    private SpriteBatch spriteBatch;
    private PooledEngine engine;
    private World world;
    private BodyFactory bodyFactory;
    private TextureAtlas atlas;



    public GameScreen(DungeonGame game) {
        super(game);
        controller = new KeyboardController();
        Objects.world = new World(new Vector2(0,-0), true);
        Objects.camera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        Objects.spriteBatch = new SpriteBatch();
        Objects.spriteBatch.setProjectionMatrix(Objects.camera.combined);


      engine = new PooledEngine();
      engine.addSystem(new DebugSystem());



        EntityUtils.createPlayer();

    }


    @Override
    public void show() {
        Gdx.input.setInputProcessor(controller);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        engine.update(delta);

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

}
