package com.dungeonsandorcs.rlgame.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.dungeonsandorcs.rlgame.components.B2dBodyComponent;
import com.dungeonsandorcs.rlgame.components.PlayerComponent;
import com.dungeonsandorcs.rlgame.utils.ComponentUtil;

import static com.dungeonsandorcs.rlgame.utils.Objects.spriteBatch;

public class RenderSystem extends IteratingSystem {

    public RenderSystem() {
            super(Family.all(PlayerComponent.class,B2dBodyComponent.class).get());

    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        spriteBatch.begin();
        B2dBodyComponent b2dBodyComponent = ComponentUtil.B_2_D_BODY_COMPONENT_MAPPER.get(entity);
        Body body =  b2dBodyComponent.body;
        Sprite sprite = new Sprite(new Texture("Creatures/spritesSheet.png"));

        float posX = body.getPosition().x;
        float posY = body.getPosition().y;
        float rotation = (float) Math.toDegrees(body.getAngle());
        sprite.setPosition(posX, posY);
        sprite.setRotation(rotation);

        sprite.draw(spriteBatch);
        spriteBatch.end();

    }

}
