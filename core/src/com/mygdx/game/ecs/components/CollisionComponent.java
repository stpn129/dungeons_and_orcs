package com.mygdx.game.ecs.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
/*
 *  Stores collision data such as entity that this entity has collided with
 */
public class CollisionComponent implements Component {
    public Entity collisionEntity;;

}
