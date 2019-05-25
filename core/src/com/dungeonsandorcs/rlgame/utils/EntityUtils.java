package com.dungeonsandorcs.rlgame.utils;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.dungeonsandorcs.rlgame.AppConstants;
import com.dungeonsandorcs.rlgame.components.B2dBodyComponent;
import com.dungeonsandorcs.rlgame.components.EnemyComponent;
import com.dungeonsandorcs.rlgame.components.PlayerComponent;

import static com.dungeonsandorcs.rlgame.AppConstants.Material.RUBBER;

public class EntityUtils {
    public static Entity createPlayer() {
        Entity entity = new Entity();

        //create components
        //fill components with data
        //add component to Entity

        PlayerComponent playerComponent = new PlayerComponent();
        EnemyComponent enemyComponent = new EnemyComponent();
        entity.add(enemyComponent);
        entity.add(playerComponent);
        B2dBodyComponent b2dBodyComponent = new B2dBodyComponent();

        Body body = BodyFactory.getInstance(Objects.world)
                .makeBoxPolyBody(RUBBER, BodyDef.BodyType.DynamicBody,
                        520f, 8f, 16f, 16f);
        b2dBodyComponent.body = body;
        Body Enemy = BodyFactory.getInstance(Objects.world)
        .makeBoxPolyBody(RUBBER,BodyDef.BodyType.StaticBody,
                536,56,16f,16f);
        Body Enemy0 = BodyFactory.getInstance(Objects.world)
        .makeBoxPolyBody(RUBBER,BodyDef.BodyType.StaticBody,
                504,56,16f,16f);

        Body house = BodyFactory.getInstance(Objects.world)
                .makeBoxPolyBody(RUBBER,BodyDef.BodyType.StaticBody,
                        520,264,16*5,16*3f);
        Body house0 = BodyFactory.getInstance(Objects.world)
                .makeBoxPolyBody(RUBBER,BodyDef.BodyType.StaticBody,
                        592 +8,144 + 8,16*5,16*3f);
        Body diamond = BodyFactory.getInstance(Objects.world)
                .makeBoxPolyBody(RUBBER,BodyDef.BodyType.StaticBody,
                        400 +8,144 + 8,16,16);
        Body stranger = BodyFactory.getInstance(Objects.world)
                .makeBoxPolyBody(RUBBER,BodyDef.BodyType.StaticBody,
                        576 +8,112 + 8,16,16);
        entity.add(b2dBodyComponent);
        return entity;
    }

}
