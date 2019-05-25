package com.dungeonsandorcs.rlgame.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.dungeonsandorcs.rlgame.components.B2dBodyComponent;

public class CheckCollisionSystem extends IteratingSystem {
    public CheckCollisionSystem(Family family) {
        super(Family.all(B2dBodyComponent.class).get());
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {

    }
}
