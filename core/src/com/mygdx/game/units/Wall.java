package com.mygdx.game.units;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.AppConstants;

public class Wall implements Creatable {
    private AppConstants.Direction direction;
    private int count;
    private Vector2 startCoord;

    public Wall(AppConstants.Direction direction, int count, Vector2 startCoord) {
        this.direction = direction;
        this.count = count;
        this.startCoord = startCoord;
    }

    @Override
    public void create(World world) {
        Vector2 addVector = getAddVector();
        for (float i = 0; i < count; i++) {
            new Box(startCoord).create(world);
            startCoord.add(addVector);
        }
    }

    private Vector2 getAddVector() {
        switch (direction) {
            case UP:
                return new Vector2(0,1);
            case RIGHT_UP:
            case UP_RIGHT:
                return new Vector2(1,1);
            case RIGHT:
                return new Vector2(1,0);
            case DOWN_RIGHT:
            case RIGHT_DOWN:
                return new Vector2(1,-1);
            case DOWN:
                return new Vector2(0,-1);
            case LEFT_DOWN:
            case DOWN_LEFT:
                return new Vector2(-1,-1);
            case LEFT:
                return new Vector2(-1,0);
            case UP_LEFT:
            case LEFT_UP:
                return new Vector2(-1,1);
            default:
                throw new IllegalArgumentException("Wrong direction: " + direction);
        }
    }


}
