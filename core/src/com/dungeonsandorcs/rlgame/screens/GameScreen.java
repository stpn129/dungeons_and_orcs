package com.dungeonsandorcs.rlgame.screens;

import com.badlogic.gdx.Screen;
import com.dungeonsandorcs.rlgame.AppConstants;
import com.dungeonsandorcs.rlgame.B2dContactListener;
import com.dungeonsandorcs.rlgame.DungeonGame;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.dungeonsandorcs.rlgame.controllers.KeyboardController;
import com.dungeonsandorcs.rlgame.ecs.components.B2dBodyComponent;
import com.dungeonsandorcs.rlgame.ecs.components.CollisionComponent;
import com.dungeonsandorcs.rlgame.ecs.components.PlayerComponent;
import com.dungeonsandorcs.rlgame.ecs.components.StateComponent;
import com.dungeonsandorcs.rlgame.ecs.components.TextureComponent;
import com.dungeonsandorcs.rlgame.ecs.components.TransformComponent;
import com.dungeonsandorcs.rlgame.ecs.components.TypeComponent;
import com.dungeonsandorcs.rlgame.ecs.systems.AnimationSystem;
import com.dungeonsandorcs.rlgame.ecs.systems.CollisionSystem;
import com.dungeonsandorcs.rlgame.ecs.systems.PhysicsDebugSystem;
import com.dungeonsandorcs.rlgame.ecs.systems.PhysicsSystem;
import com.dungeonsandorcs.rlgame.ecs.systems.PlayerControlSystem;
import com.dungeonsandorcs.rlgame.ecs.systems.RenderingSystem;

import units.BodyFactory;

public class GameScreen extends BasicScreen {



    private OrthographicCamera cam;
    private KeyboardController controller;
    private SpriteBatch sb;
    private PooledEngine engine;
    private World world;
    private BodyFactory bodyFactory;
    private Sound ping;
    private Sound boing;
    private TextureAtlas atlas;



    public GameScreen(DungeonGame game) {
        super(game);
        controller = new KeyboardController();
        world = new World(new Vector2(0,-10f), true);
        world.setContactListener(new B2dContactListener());
        bodyFactory = BodyFactory.getInstance(world);

        game.assMan.queueAddSounds();
        game.assMan.manager.finishLoading();
        atlas = game.assMan.manager.get("images/game.atlas", TextureAtlas.class);
        ping = game.assMan.manager.get("sounds/ping.wav",Sound.class);
        boing = game.assMan.manager.get("sounds/boing.wav",Sound.class);

        sb = new SpriteBatch();
        RenderingSystem renderingSystem = new RenderingSystem(sb);
        cam = renderingSystem.getCamera();
        sb.setProjectionMatrix(cam.combined);


        engine = new PooledEngine();

        engine.addSystem(new AnimationSystem());
        engine.addSystem(renderingSystem);
        engine.addSystem(new PhysicsSystem(world));
        engine.addSystem(new PhysicsDebugSystem(world, renderingSystem.getCamera()));
        engine.addSystem(new CollisionSystem());
        engine.addSystem(new PlayerControlSystem(controller));

        createPlayer();
        createPlatform(2,2);
        createPlatform(2,7);
        createPlatform(7,2);
        createPlatform(7,7);

        createFloor();

    }

    private void createPlatform(float x, float y){
        Entity entity = engine.createEntity();
        B2dBodyComponent b2dbody = engine.createComponent(B2dBodyComponent.class);
        b2dbody.body = bodyFactory.makeBoxPolyBody( AppConstants.Material.STONE, BodyType.StaticBody,x, y, 3, 0.2f);
        TextureComponent texture = engine.createComponent(TextureComponent.class);
        texture.region = atlas.findRegion("player");
        TypeComponent type = engine.createComponent(TypeComponent.class);
        type.type = TypeComponent.SCENERY;
        b2dbody.body.setUserData(entity);

        entity.add(b2dbody);
        entity.add(texture);
        entity.add(type);

        engine.addEntity(entity);

    }

    private void createFloor(){
        Entity entity = engine.createEntity();
        B2dBodyComponent b2dbody = engine.createComponent(B2dBodyComponent.class);
        b2dbody.body = bodyFactory.makeBoxPolyBody( AppConstants.Material.STONE, BodyType.StaticBody,0, 0, 100, 0.2f);
        TextureComponent texture = engine.createComponent(TextureComponent.class);
        texture.region = atlas.findRegion("player");
        TypeComponent type = engine.createComponent(TypeComponent.class);
        type.type = TypeComponent.SCENERY;


        b2dbody.body.setUserData(entity);

        entity.add(b2dbody);
        entity.add(texture);
        entity.add(type);

        engine.addEntity(entity);
    }


    private void createPlayer(){

        Entity entity = engine.createEntity();
        B2dBodyComponent b2dbody = engine.createComponent(B2dBodyComponent.class);
        TransformComponent position = engine.createComponent(TransformComponent.class);
        TextureComponent texture = engine.createComponent(TextureComponent.class);
        PlayerComponent player = engine.createComponent(PlayerComponent.class);
        CollisionComponent colComp = engine.createComponent(CollisionComponent.class);
        TypeComponent type = engine.createComponent(TypeComponent.class);
        StateComponent stateCom = engine.createComponent(StateComponent.class);

        b2dbody.body = bodyFactory.makeCirclePolyBody(10,10,1, AppConstants.Material.STONE, BodyType.DynamicBody,true);
        // set object position (x,y,z) z used to define draw order 0 first drawn
        position.position.set(10,10,0);
        texture.region = atlas.findRegion("player");
        type.type = TypeComponent.PLAYER;
        stateCom.set(StateComponent.STATE_NORMAL);
        b2dbody.body.setUserData(entity);

        entity.add(b2dbody);
        entity.add(position);
        entity.add(texture);
        entity.add(player);
        entity.add(colComp);
        entity.add(type);
        entity.add(stateCom);

        engine.addEntity(entity);

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
