package com.dungeonsandorcs.rlgame.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.dungeonsandorcs.rlgame.AppConstants;
import com.dungeonsandorcs.rlgame.components.B2dBodyComponent;
import com.dungeonsandorcs.rlgame.components.PlayerComponent;
import com.dungeonsandorcs.rlgame.utils.ComponentUtil;

public class PlayerControlSystem extends IteratingSystem {
    public PlayerControlSystem() {
        super(Family.all(PlayerComponent.class).get());
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        B2dBodyComponent b2dBodyComponent = ComponentUtil.B_2_D_BODY_COMPONENT_MAPPER.get(entity);
        Body body = b2dBodyComponent.body;
        Vector2 position = body.getTransform().getPosition();

        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            //if (cPos.y < 504 && AppConstants.isPlayerCanGo) {
            position = position.add(0, AppConstants.SPEED);
            //}
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
            //if (cPos.y > 8 && (cPos.x != 520 && cPos.y > 96) && AppConstants.isPlayerCanGo) {
            position = position.add(0, -AppConstants.SPEED);
            //}
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
            //if (cPos.x < 920 && (cPos.x != 520 && cPos.y > 80) && AppConstants.isPlayerCanGo) {
            position = position.add(AppConstants.SPEED, 0);
            //}
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
            //if (cPos.x > 232 && (cPos.x != 520 && cPos.y > 80)&&AppConstants.isPlayerCanGo) {
            position = position.add(-AppConstants.SPEED, 0);
            //}
        }
        body.setTransform(position, 0);
    }
}
