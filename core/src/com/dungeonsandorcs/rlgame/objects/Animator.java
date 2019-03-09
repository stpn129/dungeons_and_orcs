package com.dungeonsandorcs.rlgame.objects;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;


public class Animator extends ApplicationAdapter {

    private static final int FRAME_COLS = 32; // вертикаль
    private static final int FRAME_ROWS = 32; // горизонт


    private Animation<TextureRegion> walkRightAnim;
    private Animation<TextureRegion> walkLeftAnim;
    private  Animation<TextureRegion> walkUpAnim;
    private  Animation<TextureRegion> walkDownAnim;
    private  Texture walkSheet;
    private  TextureRegion[] walkRightFrames;
    private  TextureRegion[] walkLeftFrames;
    private  TextureRegion[] walkUpFrames;
    private  TextureRegion[] walkDownFrames;
    private  SpriteBatch spriteBatch;
    private  TextureRegion currentFrame;

    private  float stateTime;


    private  Rectangle spriteBox;


    @Override
    public void create() {
        walkSheet = new Texture(Gdx.files.internal("spritesSheet.png")); // #9

        TextureRegion[][] tmp = TextureRegion.split(walkSheet, walkSheet.getWidth() / FRAME_COLS, walkSheet.getHeight() / FRAME_ROWS ); // #10

        walkRightFrames = new TextureRegion[4];
        walkLeftFrames = new TextureRegion[4];
        walkUpFrames = new TextureRegion[4];
        walkDownFrames = new TextureRegion[4];

        for (int j = 0; j < 4; j++) {
            walkDownFrames[j] = tmp[0][j];
            walkUpFrames[j] = tmp[0][4 + j];
            walkLeftFrames[j] = tmp[0][4 * 2 + j];
            walkRightFrames[j] = tmp[0][4 * 2 + j];
            walkRightFrames[j].flip(true, false);
        }

        walkDownAnim = new Animation<TextureRegion>(0.25f, walkDownFrames);
        walkUpAnim = new Animation<TextureRegion>(0.25f, walkUpFrames);
        walkLeftAnim = new Animation<TextureRegion>(0.25f, walkLeftFrames);
        walkRightAnim = new Animation<TextureRegion>(0.25f, walkRightFrames);

        spriteBatch = new SpriteBatch(); // #12
        stateTime = 0f; // #13
        spriteBox = new Rectangle();
        spriteBox.height = 16;
        spriteBox.width = 16;
        spriteBox.x = 256;
        spriteBox.y = 256;

    }

    public  Animation<TextureRegion> getWalkRightAnim() {
        return walkRightAnim;
    }

    public  Animation<TextureRegion> getWalkLeftAnim() {
        return walkLeftAnim;
    }

    public  Animation<TextureRegion> getWalkUpAnim() {
        return walkUpAnim;
    }

    public  Animation<TextureRegion> getWalkDownAnim() {
        return walkDownAnim;
    }




    public  TextureRegion[] getWalkDownFrames() {
        return walkDownFrames;
    }

    public  SpriteBatch getSpriteBatch() {
        return spriteBatch;
    }

    public  TextureRegion getCurrentFrame() {
        return currentFrame;
    }

    public  float getStateTime() {
        return stateTime;
    }

    public  Rectangle getSpriteBox() {
        return spriteBox;
    }
}
