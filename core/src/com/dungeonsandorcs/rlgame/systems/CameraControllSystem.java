package com.dungeonsandorcs.rlgame.systems;

import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector3;
import com.dungeonsandorcs.rlgame.AppConstants;
import com.dungeonsandorcs.rlgame.utils.Objects;

import static com.dungeonsandorcs.rlgame.AppConstants.SPEED;

public class CameraControllSystem extends EntitySystem {
    private static Vector3 coord = new Vector3();

    @Override
    public void update(float deltaTime) {
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            coord = coord.add(new Vector3(0, AppConstants.CAMERASPEED, 0));
        } if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            coord = coord.add(new Vector3(0, -AppConstants.CAMERASPEED, 0));
        } if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            coord = coord.add(new Vector3(AppConstants.CAMERASPEED, 0, 0));
        } if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            coord = coord.add(new Vector3(-AppConstants.CAMERASPEED, 0, 0));
        }

        Objects.camera.position.lerp(coord, 0.1f);


    }
}
