package com.dungeonsandorcs.rlgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class DungeonGame extends ApplicationAdapter {
   private Player player;
   private  OrthographicCamera camera;
   private Texture walkSheet = new Texture(Gdx.files.internal("/Users/alisavolkova/Documents/AppGame/android/assets/adventurer_f.png"));
   private TextureRegion[] walkFrames;
   private SpriteBatch spriteBatch;
   private Animator animator = new Animator(walkSheet,walkFrames,spriteBatch);
   private SpriteBatch batch;

	@Override
	public void create () {


	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		animator.create();
		animator.render();
		batch.end();

	}
	
	@Override
	public void dispose () {
   batch.dispose();
	}
}
