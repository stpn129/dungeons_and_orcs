package com.mygdx.game.units;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.AppConstants;

public class BodyFactory {
    private World world;

    private static BodyFactory instance;

    private BodyFactory(World world) {
        this.world = world;
    }

    public static BodyFactory getInstance(World world) {
        if (instance == null) {
            instance = new BodyFactory(world);
        }
        return instance;
    }

    public FixtureDef makeFixture(AppConstants.Material material, Shape shape) {
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;

        switch (material) {
            case RUBBER:
                fixtureDef.density = 1f;
                fixtureDef.friction = 0f;
                fixtureDef.restitution = 1f;
                break;
            case WOOD:
                fixtureDef.density = 0.5f;
                fixtureDef.friction = 0.7f;
                fixtureDef.restitution = 0.3f;
                break;
            case STEEL:
                fixtureDef.density = 1f;
                fixtureDef.friction = 0.3f;
                fixtureDef.restitution = 0.1f;
                break;
            case STONE:
                fixtureDef.density = 1f;
                fixtureDef.friction = 0.9f;
                fixtureDef.restitution = 0.01f;
                break;
            default:
                throw new IllegalArgumentException("Wrong material: " + material);
        }

        return fixtureDef;
    }

    public Body makeBoxPolyBody(AppConstants.Material material, BodyDef.BodyType type,
                                float posX, float posY, float width, float height) {
        return makeBoxPolyBody(material, type, false, posX, posY, width, height);
    }

    public Body makeBoxPolyBody(AppConstants.Material material, BodyDef.BodyType type, boolean fixedRotation, float posX, float posY, float width, float height) {
        BodyDef boxBodyDef = new BodyDef();
        boxBodyDef.type = type;
        boxBodyDef.position.x = posX;
        boxBodyDef.position.y = posY;
        boxBodyDef.fixedRotation = fixedRotation;

        Body boxBody = world.createBody(boxBodyDef);
        PolygonShape poly = new PolygonShape();
        poly.setAsBox(width/2, height/2);
        boxBody.createFixture(makeFixture(material,poly));
        poly.dispose();

        return boxBody;
    }

    public Body makeBoxPolyBody(AppConstants.Material material, BodyDef.BodyType type, boolean fixedRotation, float... coordinates) {
        return null;
    }

    public Body makeCirclePolyBody(float posx, float posy, float radius, AppConstants.Material material){
        return makeCirclePolyBody( posx,  posy,  radius,  material,  BodyDef.BodyType.DynamicBody,  false);
    }

    public Body makeCirclePolyBody(float posx, float posy, float radius, AppConstants.Material material, BodyDef.BodyType bodyType){
        return makeCirclePolyBody( posx,  posy,  radius,  material,  bodyType,  false);
    }

    public Body makeCirclePolyBody(float posx, float posy, float radius, AppConstants.Material material, BodyDef.BodyType bodyType, boolean fixedRotation){
        // create a definition
        BodyDef boxBodyDef = new BodyDef();
        boxBodyDef.type = bodyType;
        boxBodyDef.position.x = posx;
        boxBodyDef.position.y = posy;
        boxBodyDef.fixedRotation = fixedRotation;

        //create the body to attach said definition
        Body boxBody = world.createBody(boxBodyDef);
        CircleShape circleShape = new CircleShape();
        circleShape.setRadius(radius /2);
        boxBody.createFixture(makeFixture(material,circleShape));
        circleShape.dispose();
        return boxBody;
    }
}
