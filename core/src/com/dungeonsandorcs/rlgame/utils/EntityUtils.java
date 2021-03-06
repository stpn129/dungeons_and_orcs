package com.dungeonsandorcs.rlgame.utils;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Filter;
import com.dungeonsandorcs.rlgame.AppConstants;
import com.dungeonsandorcs.rlgame.components.B2dBodyComponent;
import com.dungeonsandorcs.rlgame.components.EnemyComponent;
import com.dungeonsandorcs.rlgame.components.PlayerComponent;
import com.dungeonsandorcs.rlgame.components.QuestComponent;

import static com.dungeonsandorcs.rlgame.AppConstants.Material.RUBBER;
import static com.dungeonsandorcs.rlgame.AppConstants.Material.STEEL;

public class EntityUtils {
    public static Entity createPlayer() {
        Entity entity = new Entity();

        PlayerComponent playerComponent = new PlayerComponent();
        EnemyComponent enemyComponent = new EnemyComponent();
        QuestComponent questComponent = new QuestComponent();
        B2dBodyComponent b2dBodyComponent = new B2dBodyComponent();

        b2dBodyComponent.body = BodyFactory.getInstance(Objects.world)
                .makeBoxPolyBody(RUBBER, BodyDef.BodyType.DynamicBody,
                        520f, 8f, 16f, 16f);
        Filter filter = b2dBodyComponent.body.getFixtureList().first().getFilterData();
        filter.categoryBits = AppConstants.MARIO_BIT ;
        b2dBodyComponent.body.getFixtureList().first().setFilterData(filter);
        b2dBodyComponent.body.setFixedRotation(true);

        entity.add(b2dBodyComponent);
        entity.add(enemyComponent);
        entity.add(playerComponent);
        entity.add(questComponent);
        return entity;
    }

    public static Entity createHouse(float posX, float posY, float width, float height) {
        Entity entity = new Entity();

        B2dBodyComponent b2dBodyComponent = new B2dBodyComponent();
        b2dBodyComponent.body = BodyFactory.getInstance(Objects.world)
                .makeBoxPolyBody(RUBBER, BodyDef.BodyType.StaticBody,
                        posX, posY, width, height);
        Filter filter = b2dBodyComponent.body.getFixtureList().first().getFilterData();
        filter.categoryBits = AppConstants.BRICK_BIT ;
        b2dBodyComponent.body.getFixtureList().first().setFilterData(filter);
        entity.add(b2dBodyComponent);

        return entity;
    }
}
