package com.dungeonsandorcs.rlgame.screens;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.BinaryHeap;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
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
import static com.dungeonsandorcs.rlgame.utils.Objects.spriteBatch;

public class GameScreen extends ObjectsScreen {

    private PooledEngine engine;
    private Stage stage;

    public GameScreen(DungeonGame game) {
        super(game);
        engine = new PooledEngine();
        engine.addSystem(new ContactListenerSystem());
        engine.addSystem(new RenderSystem(Objects.renderer));
        engine.addSystem(new DebugSystem());
        engine.addSystem(new PlayerControlSystem());
        engine.addSystem(new CameraControllSystem());
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        Gdx.input.setInputProcessor(new KeyboardController());
    }


    @Override
    public void show() {
        engine.addEntity(EntityUtils.createPlayer());
        setCollisionObjects(engine);
        BitmapFont font = new BitmapFont(Gdx.files.internal("glassy/skin/font-export.fnt"),Gdx.files.internal("glassy/skin/glassy-ui.png"),false);


//
//        Table table = new Table();
//        table.setFillParent(true);
//        stage.addActor(table);
//        Button up = new Button();
//        Button down = new Button();
//        Button right = new Button();
//        Button left = new Button();
//
//        table.add(up).fillX().uniformX();
//        table.row().pad(0,0,10,10);

        //   Skin skin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));


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

    public void setCollisionObjects(Engine engine){
        engine.addEntity(createHouse(512 + 8, -16 + 8, 16f * 78 - 78 * AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(496 + 8, 16 + 8, 16f - AppConstants.EPS, 16f * 3 - 3 * AppConstants.EPS));
        engine.addEntity(createHouse(528 + 8, 16 + 8, 16f - AppConstants.EPS, 16f * 3 - 3 * AppConstants.EPS));
        engine.addEntity(createHouse(536, 56, 16f - AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(504, 56, 16f - AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(416 + 8, 304 + 8, 16 * 9 - 9 * AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(480 + 8, 384 + 8, 16 - AppConstants.EPS, 16f * 9 - 10 * AppConstants.EPS));
        engine.addEntity(createHouse(352 + 8, 384 + 8, 16 - AppConstants.EPS, 16f * 9 - 10 * AppConstants.EPS));
        engine.addEntity(createHouse(416 + 8, 448 + 8, 16 * 9 - 9 * AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(512 + 8, 256 + 8, 16 * 5 - 5 * AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(512 + 8, 240 + 8, 16 * 5 - 5 * AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(512 + 8, 272 + 8, 16 * 3 - 3 * AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(592 + 8, 272 + 8, 16 * 3 - 3 * AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(592 + 8, 288 + 8, 16 * 3 - 3 * AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(640 + 8, 288 + 8, 16 * 3 - 3 * AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(656 + 8, 192 + 8, 16 * 5 - 5 * AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(640 + 8, 208 + 8, 16 * 3 - 3 * AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(608 + 8, 192 + 8, 16f - AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(672 + 8, 208 + 8, 16f - AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(592 + 8, 128 + 8, 16 * 5 - 5 * AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(592 + 8, 160 + 8, 16f - AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(576 + 8, 160 + 8, 16f - AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(608 + 8, 144 + 8, 16f - AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(576 + 8, 144 + 8, 16 * 3 - 3 * AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(576 + 8, 112 + 8, 16 - AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(544 + 8, 112 + 8, 16 - AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(560 + 8, 224 + 8, 16 - AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(496 + 8, 176 + 8, 16 - AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(448 + 8, 208 + 8, 16 - AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(400 + 8, 160 + 8, 16 - AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(288 + 8, 96 + 8, 16 - AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(256 + 8, 96 + 8, 16 - AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(224 + 8, 96 + 8, 16 - AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(656 + 8, 512 + 8, 16 * 3 - 3 * AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(656 + 8, 496 + 8, 16 * 3 - 3 * AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(656 + 8, 256 + 8, 16 - AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(768 + 8, 288 + 8, 16 * 3 - 3 * AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(768 + 8, 304 + 8, 16 * 3 - 3 * AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(816 + 8, 368 + 8, 16 * 7 - 7 * AppConstants.EPS, 16f * 5 - 5 * AppConstants.EPS));
        engine.addEntity(createHouse(816 + 8, 176 + 8, 16 - AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(752 + 8, 432 + 8, 16 * 5 - 5 * AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(736 + 8, 448 + 8, 16 * 3 - 3 * AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(768 + 8, 448 + 8, 16 - AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(752 + 8, 464 + 8, 16 - AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(352 + 8, 64 + 8, 16 * 19 - 19 * AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(352 + 8, 80 + 8, 16 * 19 - 19 * AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(208 + 8, 320 + 8, 16 - AppConstants.EPS, 16f * 28 - 28 * AppConstants.EPS));
        engine.addEntity(createHouse(944 + 8, 304 + 8, 16 - AppConstants.EPS, 16f * 28 - 28 * AppConstants.EPS));
        engine.addEntity(createHouse(448 + 8, 528 + 8, 16 * 100 - 100 * AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(256 + 8, 128 + 8, 16 * 5 - 5 * AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(256 + 8, 144 + 8, 16 * 5 - 5 * AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(256 + 8, 160 + 8, 16 * 3 - 3 * AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(288 + 8, 160 + 8, 16 - AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(304 + 8, 128 + 8, 16 - AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(336 + 8, 160 + 8, 16 - AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(368 + 8, 192 + 8, 16 * 5 - 5 * AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(320 + 8, 192 + 8, 16 - AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(352 + 8, 240 + 8, 16 * 5 - 5 * AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(352 + 8, 256 + 8, 16 * 3 - 3 * AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(352 + 8, 272 + 8, 16 - AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(368 + 8, 224 + 8, 16 - AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(368 + 8, 208 + 8, 16 - AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(384 + 8, 208 + 8, 16 - AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(624 + 8, 336 + 8, 16 - AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(592 + 8, 336 + 8, 16 - AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(656 + 8, 336 + 8, 16 * 3 - 3 * AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(560 + 8, 336 + 8, 16 * 3 - 3 * AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(544 + 8, 400 + 8, 16 - AppConstants.EPS, 16f * 7 - 7 * AppConstants.EPS));
        engine.addEntity(createHouse(672 + 8, 400 + 8, 16 - AppConstants.EPS, 16f * 7 - 7 * AppConstants.EPS));
        engine.addEntity(createHouse(608 + 8, 448 + 8, 16 * 9 - 9 * AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(624 + 8, 416 + 8, 16 * 3 - 3 * AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(576 + 8, 416 + 8, 16 - AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(624 + 8, 368 + 8, 16 - AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(640 + 8, 352 + 8, 16 - AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(640 + 8, 384 + 8, 16 - AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(576 + 8, 352 + 8, 16 - AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(576 + 8, 384 + 8, 16 - AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(736 + 8, 80 + 8, 16 * 27 - AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(736 + 8, 64 + 8, 16 * 27 - AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(928 + 8, 304 + 8, 16 - AppConstants.EPS, 16f * 28 - 28 * AppConstants.EPS));
        engine.addEntity(createHouse(912 + 8, 96 + 8, 16 - AppConstants.EPS, 16f * 3 - 3 * AppConstants.EPS));
        engine.addEntity(createHouse(912 + 8, 208 + 8, 16 - AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(912 + 8, 272 + 8, 16 - AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(912 + 8, 368 + 8, 16 - AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(912 + 8, 448 + 8, 16 - AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(864 + 8, 512 + 8, 16 - AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(832 + 8, 512 + 8, 16 - AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(688 + 8, 384 + 8, 16 - AppConstants.EPS, 16f - AppConstants.EPS));
        engine.addEntity(createHouse(528 + 8, 368 + 8, 16 - AppConstants.EPS, 16f - AppConstants.EPS));

    }
}
