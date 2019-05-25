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

public class EntityUtils {
    public static final Entity createPlayer() {
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
                .makeBoxPolyBody(AppConstants.Material.RUBBER, BodyDef.BodyType.StaticBody,
                        520f, 8f, 16f, 16f);
        b2dBodyComponent.body = body;
//Body bodyEnemy = BodyFactory.getInstance(Objects.world)
//        .makeBoxPolyBody(AppConstants.Material.RUBBER,BodyDef.BodyType.StaticBody,
//                2,2,16f,16f);
//        Body wall = BodyFactory.getInstance(Objects.world)
//                .makeBoxPolyBody(AppConstants.Material.RUBBER,BodyDef.BodyType.StaticBody,
//                        5,5,16f,56*16f);
        entity.add(b2dBodyComponent);
        return entity;
    }

}
