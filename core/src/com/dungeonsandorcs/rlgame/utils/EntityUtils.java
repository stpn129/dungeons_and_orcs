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
import com.dungeonsandorcs.rlgame.components.QuestComponent;

import static com.dungeonsandorcs.rlgame.AppConstants.Material.RUBBER;

public class EntityUtils {
    public static Entity createPlayer() {
        Entity entity = new Entity();

        //create components
        //fill components with data
        //add component to Entity

        PlayerComponent playerComponent = new PlayerComponent();
        EnemyComponent enemyComponent = new EnemyComponent();
        QuestComponent questComponent = new QuestComponent();
        entity.add(enemyComponent);
        entity.add(playerComponent);
        entity.add(questComponent);
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
                        256+8,144+8,16*5,16*3f);
        Body house0 = BodyFactory.getInstance(Objects.world)
                .makeBoxPolyBody(RUBBER,BodyDef.BodyType.StaticBody,
                        368+8,208+8,16*5,16*3f);
        Body house1 = BodyFactory.getInstance(Objects.world)
                .makeBoxPolyBody(RUBBER,BodyDef.BodyType.StaticBody,
                        352+8,256+8,16*5,16*3f);
        Body house2 = BodyFactory.getInstance(Objects.world)
                .makeBoxPolyBody(RUBBER,BodyDef.BodyType.StaticBody,
                        416+8,368+8,16*10,10*16f);
        Body house3 = BodyFactory.getInstance(Objects.world)
                .makeBoxPolyBody(RUBBER,BodyDef.BodyType.StaticBody,
                        512+8,256+8,16*5,3*16f);
        Body house4 = BodyFactory.getInstance(Objects.world)
                .makeBoxPolyBody(RUBBER,BodyDef.BodyType.StaticBody,
                        608+8,400+8,16*9,8*16f);
        Body house5 = BodyFactory.getInstance(Objects.world)
                .makeBoxPolyBody(RUBBER,BodyDef.BodyType.StaticBody,
                        768+8,288+8,16*3,3*16f);
        Body house6 = BodyFactory.getInstance(Objects.world)
                .makeBoxPolyBody(RUBBER,BodyDef.BodyType.StaticBody,
                        576+8,144+8,16*4,3*16f);
        Body house7 = BodyFactory.getInstance(Objects.world)
                .makeBoxPolyBody(RUBBER,BodyDef.BodyType.StaticBody,
                        656+8,208+8,16*6,3*16f);
        Body house8 = BodyFactory.getInstance(Objects.world)
                .makeBoxPolyBody(RUBBER,BodyDef.BodyType.StaticBody,
                        592+8,272+8,16*3,16*2f);
        Body house9 = BodyFactory.getInstance(Objects.world)
                .makeBoxPolyBody(RUBBER,BodyDef.BodyType.StaticBody,
                        816+8,368+8,16*7,16*5f);
        Body house10 = BodyFactory.getInstance(Objects.world)
                .makeBoxPolyBody(RUBBER,BodyDef.BodyType.StaticBody,
                        752+8,448+8,16*6,16*3f);
        Body house11 = BodyFactory.getInstance(Objects.world)
                .makeBoxPolyBody(RUBBER,BodyDef.BodyType.StaticBody,
                        656+8,496+8,16*3,16*2f);
        Body diamond = BodyFactory.getInstance(Objects.world)
                .makeBoxPolyBody(RUBBER,BodyDef.BodyType.StaticBody,
                        240 +8,384 + 8,16,16);
        Body stranger = BodyFactory.getInstance(Objects.world)
                .makeBoxPolyBody(RUBBER,BodyDef.BodyType.StaticBody,
                        576 +8,112 + 8,16,16);
        entity.add(b2dBodyComponent);
        return entity;
    }

}
