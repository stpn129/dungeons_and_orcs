package com.dungeonsandorcs.rlgame;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;

public class ContactListener implements com.badlogic.gdx.physics.box2d.ContactListener {
    @Override
    public void beginContact(Contact contact) {
        System.out.println("Contact");
        Fixture fa = contact.getFixtureA();
        Fixture fb = contact.getFixtureB();
        System.out.println(fa.getBody().getType()+" has hit "+ fb.getBody().getType());
        if(fa.getBody().getUserData().equals("cannot go")){
            System.out.print("cannot go");
        }
    }

    @Override
    public void endContact(Contact contact) {
        System.out.print("End contact");
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
