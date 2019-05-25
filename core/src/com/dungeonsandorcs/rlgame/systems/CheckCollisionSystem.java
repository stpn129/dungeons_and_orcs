package com.dungeonsandorcs.rlgame.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.physics.box2d.Body;
import com.dungeonsandorcs.rlgame.components.B2dBodyComponent;
import com.dungeonsandorcs.rlgame.utils.EntityUtils;

public class CheckCollisionSystem extends IteratingSystem {
    public CheckCollisionSystem(Family family) {
        super(Family.all(B2dBodyComponent.class).get());
    }
    public static boolean isPlayerCanGoUp;
    public static boolean isPlayerCanGoDown;
    public static boolean isPlayerCanGoLeft;
    public static boolean isPlayerCanGoRight;

    @Override
    protected void processEntity(Entity entity, float deltaTime) {

    }
}
