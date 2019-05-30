package com.dungeonsandorcs.rlgame.systems;

import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.dungeonsandorcs.rlgame.AppConstants;
import com.dungeonsandorcs.rlgame.utils.Objects;

public class ContactListenerSystem extends EntitySystem implements ContactListener {
    public static boolean isPlayerOutBounds = false;

    public ContactListenerSystem() {
        Objects.world.setContactListener(this);
    }

    @Override
    public void beginContact(Contact contact) {
        System.out.println("Contact");

        Fixture fixA = contact.getFixtureA();
        Fixture fixB = contact.getFixtureB();
        int cDef = fixA.getFilterData().categoryBits | fixB.getFilterData().categoryBits;

        System.out.println(fixA.getFilterData().categoryBits);
        System.out.println(fixB.getFilterData().categoryBits);
        System.out.println(cDef);

        switch (cDef) {
            case AppConstants.MARIO_BIT | AppConstants.BRICK_BIT:
                System.out.println(fixA.getBody().getLinearVelocity());
                fixA.getBody().getLinearVelocity().x = -fixA.getBody().getLinearVelocity().x;
                fixA.getBody().getLinearVelocity().y = -fixA.getBody().getLinearVelocity().y;
                System.out.println(fixA.getBody().getLinearVelocity());
                System.out.println(fixB.getBody().getLinearVelocity());
                fixB.getBody().getLinearVelocity().x = -fixB.getBody().getLinearVelocity().x;
                fixB.getBody().getLinearVelocity().y = -fixB.getBody().getLinearVelocity().y;
                System.out.println(fixB.getBody().getLinearVelocity());
        }
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
