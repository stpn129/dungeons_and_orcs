package com.dungeonsandorcs.rlgame.systems;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.physics.box2d.Body;
import com.dungeonsandorcs.rlgame.components.AnimationComponent;
import com.dungeonsandorcs.rlgame.components.B2dBodyComponent;
import com.dungeonsandorcs.rlgame.components.PlayerComponent;
import com.dungeonsandorcs.rlgame.components.ScoreComponent;
import com.dungeonsandorcs.rlgame.components.TextureComponent;
import com.dungeonsandorcs.rlgame.utils.ComponentUtil;

public class PlayerControlSystem extends IteratingSystem {
    public PlayerControlSystem() {
        super(Family.all(PlayerComponent.class).get());
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        B2dBodyComponent b2dBodyComponent = ComponentUtil.B_2_D_BODY_COMPONENT_MAPPER.get(entity);
        Body body =  b2dBodyComponent.body;


    }
}
