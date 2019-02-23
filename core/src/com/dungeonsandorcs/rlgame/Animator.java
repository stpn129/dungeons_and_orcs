package com.dungeonsandorcs.rlgame;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Animator implements ApplicationListener {

    private static final int FRAME_COLS =  4; // вертикаль
    private static final int FRAME_ROWS = 4; // горизонт


    private Animation walkAnimation;
    private Texture walkSheet;
    private TextureRegion[] walkFrames;
    private SpriteBatch spriteBatch;
    private TextureRegion currentFrame;

    private float stateTime;


    public Animator(Texture walkSheet, TextureRegion[] walkFrames, SpriteBatch spriteBatch) {
    }

    @Override
    public void create() {
        walkSheet = new Texture(Gdx.files.internal("/Users/alisavolkova/Documents/AppGame/android/assets/adventurer_f.png")); // #9
        TextureRegion[][] tmp = TextureRegion.split(walkSheet, walkSheet.getWidth()/FRAME_COLS, walkSheet.getHeight()/FRAME_ROWS); // #10
        walkFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        int index = 0;
        for (int i = 0; i < FRAME_ROWS; i++) {
            for (int j = 0; j < FRAME_COLS; j++) {
                walkFrames[index++] = tmp[i][j];
            }
        }
        walkAnimation = new Animation(0.25f, walkFrames); // #11
        spriteBatch = new SpriteBatch(); // #12
        stateTime = 0f; // #13
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT); // #14
        stateTime += Gdx.graphics.getDeltaTime(); // #15
        currentFrame = (TextureRegion) walkAnimation.getKeyFrame(stateTime, true); // #16
        spriteBatch.begin();
        spriteBatch.draw(currentFrame, 256, 256); // #17
        spriteBatch.end();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }

    public static int getFrameCols() {
        return FRAME_COLS;
    }

    public static int getFrameRows() {
        return FRAME_ROWS;
    }

    public Animation getWalkAnimation() {
        return walkAnimation;
    }

    public Texture getWalkSheet() {
        return walkSheet;
    }

    public TextureRegion[] getWalkFrames() {
        return walkFrames;
    }

    public SpriteBatch getSpriteBatch() {
        return spriteBatch;
    }

    public TextureRegion getCurrentFrame() {
        return currentFrame;
    }

    public float getStateTime() {
        return stateTime;
    }
}
