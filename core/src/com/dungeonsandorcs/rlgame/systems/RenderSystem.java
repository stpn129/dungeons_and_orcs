package com.dungeonsandorcs.rlgame.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;

public class RenderSystem extends IteratingSystem {

    public RenderSystem(Family family) {
        super(family);

    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {

    }
}
