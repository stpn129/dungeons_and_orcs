package com.dungeonsandorcs.rlgame.systems;

import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector3;
import com.dungeonsandorcs.rlgame.AppConstants;
import com.dungeonsandorcs.rlgame.utils.Objects;

import static com.dungeonsandorcs.rlgame.AppConstants.SPEED;
import static com.dungeonsandorcs.rlgame.systems.RenderSystem.cPos;

public class CameraControllSystem extends EntitySystem {
    private static Vector3 coord = new Vector3();

    @Override
    public void update(float deltaTime) {
        coord.x = cPos.x;
        coord.y = cPos.y;
        coord.z = 0;

        Objects.camera.position.lerp(coord, 0.1f);
    }
}
