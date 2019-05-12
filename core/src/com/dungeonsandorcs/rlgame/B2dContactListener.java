package com.dungeonsandorcs.rlgame;


import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;

public class B2dContactListener implements ContactListener {

	//private B2dModel parent;
	
	public B2dContactListener(){ //B2dModel parent){
		//this.parent = parent;
	}
	
	@Override
	public void beginContact(Contact contact) {
		System.out.println("Contact");
		Fixture fa = contact.getFixtureA();
		Fixture fb = contact.getFixtureB();
		System.out.println(fa.getBody().getType()+" has hit "+ fb.getBody().getType());
		
		if(fa.getBody().getUserData() instanceof Entity){
			Entity ent = (Entity) fa.getBody().getUserData();
		//	entityCollision(ent,fb);
			return;
		}else if(fb.getBody().getUserData() instanceof Entity){
			Entity ent = (Entity) fb.getBody().getUserData();
		//	entityCollision(ent,fa);
			return;
		}
	}


	@Override
	public void endContact(Contact contact) {
		System.out.println("Contact end");
	}
	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {		
	}
	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {		
	}

}
