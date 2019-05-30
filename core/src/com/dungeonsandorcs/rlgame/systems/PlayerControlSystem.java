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
import com.dungeonsandorcs.rlgame.utils.Objects;

public class PlayerControlSystem extends IteratingSystem {

    public PlayerControlSystem() {
        super(Family.all(PlayerComponent.class).get());
    }

    private float elapsed;
    private boolean mustRound = false;
    private Vector2 toP = new Vector2();

    private int count = 0;

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        elapsed += deltaTime;
        B2dBodyComponent b2dBodyComponent = ComponentUtil.B_2_D_BODY_COMPONENT_MAPPER.get(entity);
        Body body = b2dBodyComponent.body;
        Vector2 position = body.getTransform().getPosition();
        //System.out.println(position);

        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.O)) {
            System.out.println("O");
            b2dBodyComponent.body.setTransform(520f, 8f, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.E)) {
            Objects.camera.zoom += 0.3f;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.Q)) {
            Objects.camera.zoom -= 0.3f;
        }

        float TIME = 0.2f;
        if (elapsed <= TIME) {
            count++;
            body.setLinearVelocity(toP);
        } else {
            if (mustRound) {
                System.out.println("ROUND->" + body.getPosition());
                b2dBodyComponent.body.setTransform(norm(body.getPosition()), 0);
                System.out.println("ROUND<-" + body.getPosition());
                mustRound = false;
            }
            body.setLinearVelocity(0, 0);
            if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
                move(new Vector2(0, AppConstants.SPEED / TIME));
            }

            if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
                move(new Vector2(0, -AppConstants.SPEED / TIME));
            }

            if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
                move(new Vector2(AppConstants.SPEED / TIME, 0));
            }

            if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
                move(new Vector2(-AppConstants.SPEED / TIME, 0));
            }
        }
    }

    private void move(Vector2 direct) {
        elapsed = 0;
        toP =direct;
        mustRound = true;
    }

    private Vector2 norm(Vector2 position) {
        return new Vector2(round(position.x), round(position.y));
    }

    private float round(float i) {
        int v = 8;
        return Math.round(i / v) * v;
    }
}
