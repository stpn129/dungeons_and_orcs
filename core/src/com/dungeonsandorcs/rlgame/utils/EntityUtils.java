package com.dungeonsandorcs.rlgame.utils;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.dungeonsandorcs.rlgame.AppConstants;
import com.dungeonsandorcs.rlgame.components.B2dBodyComponent;
import com.dungeonsandorcs.rlgame.components.PlayerComponent;

public class EntityUtils {
    public static final Entity createPlayer() {
        Entity entity = new Entity();

        //create components
        //fill components with data
        //add component to Entity

        PlayerComponent playerComponent = new PlayerComponent();
        Sprite sprite = new Sprite(new Texture("android/assets/skins/spritesSheet.png"));
        
        entity.add(playerComponent);
        B2dBodyComponent b2dBodyComponent = new B2dBodyComponent();
        Body body = BodyFactory.getInstance(Objects.world)
                .makeBoxPolyBody(AppConstants.Material.RUBBER, BodyDef.BodyType.StaticBody,
                        0, 0, 1f, 1f);
        b2dBodyComponent.body = body;

        entity.add(b2dBodyComponent);
        return entity;
    }

}
