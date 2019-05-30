package com.dungeonsandorcs.rlgame.screens;

import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.dungeonsandorcs.rlgame.AppConstants;
import com.dungeonsandorcs.rlgame.DungeonGame;
import com.dungeonsandorcs.rlgame.controllers.KeyboardController;
import com.dungeonsandorcs.rlgame.systems.CameraControllSystem;
import com.dungeonsandorcs.rlgame.systems.ContactListenerSystem;
import com.dungeonsandorcs.rlgame.systems.DebugSystem;
import com.dungeonsandorcs.rlgame.systems.PlayerControlSystem;
import com.dungeonsandorcs.rlgame.systems.RenderSystem;
import com.dungeonsandorcs.rlgame.utils.EntityUtils;
import com.dungeonsandorcs.rlgame.utils.Objects;

import static com.dungeonsandorcs.rlgame.utils.EntityUtils.createHouse;

public class GameScreen extends ObjectsScreen {

    private PooledEngine engine;

    public GameScreen(DungeonGame game) {
        super(game);
        engine = new PooledEngine();
        engine.addSystem(new ContactListenerSystem());
        engine.addSystem(new RenderSystem(Objects.renderer));
        engine.addSystem(new DebugSystem());
        engine.addSystem(new PlayerControlSystem());
        engine.addSystem(new CameraControllSystem());
        Gdx.input.setInputProcessor(new KeyboardController());
    }


    @Override
    public void show() {
        engine.addEntity(EntityUtils.createPlayer());

        engine.addEntity(createHouse(520f, 40f, 16f - AppConstants.EPS, 16f - AppConstants.EPS));
        //engine.addEntity(createHouse(536, 56, 16f, 16f));
        //engine.addEntity(createHouse(504, 56, 16f, 16f));
        //engine.addEntity(createHouse(256 + 8, 144 + 8, 16 * 5, 16 * 3f));
        //engine.addEntity(createHouse(368 + 8, 208 + 8, 16 * 5, 16 * 3f));
        //engine.addEntity(createHouse(352 + 8, 256 + 8, 16 * 5, 16 * 3f));
        //engine.addEntity(createHouse(416 + 8, 368 + 8, 16 * 10, 10 * 16f));
        //engine.addEntity(createHouse(512 + 8, 256 + 8, 16 * 5, 3 * 16f));
        //engine.addEntity(createHouse(608 + 8, 400 + 8, 16 * 9, 8 * 16f));
        //engine.addEntity(createHouse(768 + 8, 288 + 8, 16 * 3, 3 * 16f));
        //engine.addEntity(createHouse(576 + 8, 144 + 8, 16 * 4, 3 * 16f));
        //engine.addEntity(createHouse(656 + 8, 208 + 8, 16 * 6, 3 * 16f));
        //engine.addEntity(createHouse(592 + 8, 272 + 8, 16 * 3, 16 * 2f));
        //engine.addEntity(createHouse(816 + 8, 368 + 8, 16 * 7, 16 * 5f));
        //engine.addEntity(createHouse(752 + 8, 448 + 8, 16 * 6, 16 * 3f));
        //engine.addEntity(createHouse(656 + 8, 496 + 8, 16 * 3, 16 * 2f));
        //engine.addEntity(createHouse(240 + 8, 384 + 8, 16, 16));
        //engine.addEntity(createHouse(576 + 8, 112 + 8, 16, 16));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        Objects.update(delta);
        engine.update(delta);
    }

    @Override
    public void dispose() {
        Objects.dispose();
    }

}
