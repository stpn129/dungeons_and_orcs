package com.mygdx.game.units;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class Box implements Creatable {
    private float xCoord, yCoord;

    public Box(float xCoord, float yCoord) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    public Box(Vector2 coords) {
        this.xCoord = coords.x;
        this.yCoord = coords.y;
    }

    @Override
    public void create(World world) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(xCoord,yCoord);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(0.5f,0.5f);

        world.createBody(bodyDef).createFixture(shape,0f);
        shape.dispose();
    }
}
