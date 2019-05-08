package com.dungeonsandorcs.rlgame.utils;

import com.badlogic.ashley.core.Entity;
import com.dungeonsandorcs.rlgame.components.PlayerComponent;

public class EntityUtils {
    public static final Entity createPlayer() {
        Entity entity = new Entity();

        //create components
        //fill components with data
        //add component to Entity

        //Example:
        PlayerComponent playerComponent = new PlayerComponent();
        entity.add(playerComponent);

        return entity;
    }
}
