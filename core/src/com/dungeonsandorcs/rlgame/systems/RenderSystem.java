package com.dungeonsandorcs.rlgame.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.dungeonsandorcs.rlgame.components.B2dBodyComponent;
import com.dungeonsandorcs.rlgame.components.PlayerComponent;
import com.dungeonsandorcs.rlgame.utils.ComponentUtil;
import com.dungeonsandorcs.rlgame.utils.Objects;

import static com.dungeonsandorcs.rlgame.utils.Objects.spriteBatch;

public class RenderSystem extends IteratingSystem {
   public OrthogonalTiledMapRenderer renderer0;

   private static final float hero_width = 16f;
   private static final float hero_height = 16f;
   public static Vector2 cPos;

    public RenderSystem( OrthogonalTiledMapRenderer renderer0) {
        super(Family.all(PlayerComponent.class,B2dBodyComponent.class).get());

        this.renderer0 = renderer0;
    }



    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        Batch batch = renderer0.getBatch();
        batch.begin();
        B2dBodyComponent b2dBodyComponent = ComponentUtil.B_2_D_BODY_COMPONENT_MAPPER.get(entity);
        Body body =  b2dBodyComponent.body;
        Sprite sprite = new Sprite(new Texture("Creatures/hero.png"));
        Vector2 pos = new Vector2();
         cPos = new Vector2();

        pos.set(body.getPosition());

        cPos.x = pos.x - hero_width/2;
        cPos.y = pos.y - hero_height/2;
        sprite.setPosition(cPos.x, cPos.y);
        float rotation = (float) Math.toDegrees(body.getAngle());
        sprite.setRotation(rotation);
        batch.draw(sprite,cPos.x,cPos.y);
        batch.end();

    }

}
