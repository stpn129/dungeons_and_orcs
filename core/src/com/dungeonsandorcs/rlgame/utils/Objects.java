package com.dungeonsandorcs.rlgame.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.dungeonsandorcs.rlgame.AppConstants;

public class Objects {
    public static SpriteBatch spriteBatch;
    public static OrthographicCamera camera;
    public static World world;
    public static OrthogonalTiledMapRenderer renderer;

    public static void create() {
        TiledMap map = new TmxMapLoader().load("maps/Tilemap/level.tmx");

        world = new World(new Vector2(0, 0), false);

        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.setToOrtho(false, AppConstants.viewportWidth, AppConstants.viewportHeight);
        camera.zoom = 10f;

        spriteBatch = new SpriteBatch();
        spriteBatch.setProjectionMatrix(camera.combined);

        renderer = new OrthogonalTiledMapRenderer(map, AppConstants.unitScale);
        renderer.setView(Objects.camera);
    }

    public static void update(float delta) {
        renderer.render();
        renderer.setView(Objects.camera);
        Objects.world.step(delta,100,1);
    }

    public static void dispose() {
        spriteBatch = null;
        camera = null;
        world = null;
        renderer = null;
    }
}
