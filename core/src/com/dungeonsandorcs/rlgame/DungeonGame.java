package com.dungeonsandorcs.rlgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class DungeonGame extends ApplicationAdapter {

	private static final int FRAME_COLS =  4; // вертикаль
	 private static final int FRAME_ROWS = 4; // горизонт

   private Player player;
   private  OrthographicCamera camera;
   private Animator animator = new Animator();
   private SpriteBatch batch;

	@Override
	public void create () {

		animator.create();

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		animator.render();
		batch.end();

	}
	
	@Override
	public void dispose () {
   batch.dispose();
	}
}
