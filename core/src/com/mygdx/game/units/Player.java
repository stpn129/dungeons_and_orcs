package com.mygdx.game.units;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.AppConstants;
import com.mygdx.game.ecs.components.AnimationComponent;
import com.mygdx.game.ecs.components.B2dBodyComponent;
import com.mygdx.game.ecs.components.CollisionComponent;
import com.mygdx.game.ecs.components.PlayerComponent;
import com.mygdx.game.ecs.components.StateComponent;
import com.mygdx.game.ecs.components.TextureComponent;
import com.mygdx.game.ecs.components.TransformComponent;
import com.mygdx.game.ecs.components.TypeComponent;
import com.mygdx.game.utils.AshleyUtils;

public class Player extends Entity {
    private AnimationComponent animation;
    private B2dBodyComponent body;
    private CollisionComponent collision;
    private PlayerComponent player;
    private StateComponent state;
    private TextureComponent texture;
    private TransformComponent transform;
    private TypeComponent type;

    public Player(BodyFactory bodyFactory, TextureAtlas atlas) {
        B2dBodyComponent b2dbody = new B2dBodyComponent();
        TransformComponent position = new TransformComponent();
        TextureComponent texture = new TextureComponent();
        PlayerComponent player = new PlayerComponent();
        CollisionComponent colComp = new CollisionComponent();
        TypeComponent type = new TypeComponent();
        StateComponent stateCom = new StateComponent();

        b2dbody.body = bodyFactory.makeCirclePolyBody(10, 10, 1, AppConstants.Material.STONE, BodyDef.BodyType.DynamicBody, true);
        // set object position (x,y,z) z used to define draw order 0 first drawn
        position.position.set(10, 10, 0);
        texture.region = atlas.findRegion("player");
        type.type = TypeComponent.PLAYER;
        stateCom.set(StateComponent.STATE_NORMAL);
        b2dbody.body.setUserData(this);
    }

    public void register(PooledEngine engine) {
        engine.addEntity(this);
    }
}
