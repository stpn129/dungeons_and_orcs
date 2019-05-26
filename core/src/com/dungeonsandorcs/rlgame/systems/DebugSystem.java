package com.dungeonsandorcs.rlgame.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.dungeonsandorcs.rlgame.utils.Objects;

public class DebugSystem extends IteratingSystem {

    private Box2DDebugRenderer debugRenderer;

    public DebugSystem(){
        super(Family.all().get());
        debugRenderer = new Box2DDebugRenderer();
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
      //  debugRenderer.render(Objects.world, Objects.camera.combined);
        Objects.camera.update();

    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {

    }
}
