package com.dungeonsandorcs.rlgame.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.dungeonsandorcs.rlgame.AppConstants;
import com.dungeonsandorcs.rlgame.components.B2dBodyComponent;
import com.dungeonsandorcs.rlgame.utils.EntityUtils;
import com.dungeonsandorcs.rlgame.utils.Objects;

public class CheckCollisionSystem extends IteratingSystem implements ContactListener {
    public CheckCollisionSystem() {
        super(Family.all(B2dBodyComponent.class).get());
        Objects.world.setContactListener(this);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        entity.getComponent(B2dBodyComponent.class);
    }

    @Override
    public void beginContact(Contact contact) {
        System.out.println("Contact");
        Fixture fa = contact.getFixtureA();
        Fixture fb = contact.getFixtureB();
        System.out.println(fa.getBody().getType()+" has hit "+ fb.getBody().getType());

        AppConstants.isPlayerCanGo = fa.getBody().getUserData() != "cgo";
    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
