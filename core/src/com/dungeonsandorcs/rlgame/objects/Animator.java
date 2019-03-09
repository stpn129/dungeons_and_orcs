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


    private static Animation<TextureRegion> walkRightAnim;
    private static Animation<TextureRegion> walkLeftAnim;
    private static Animation<TextureRegion> walkUpAnim;
    private static Animation<TextureRegion> walkDownAnim;
    private static Texture walkSheet;
    private static TextureRegion[] walkRightFrames;
    private static TextureRegion[] walkLeftFrames;
    private static TextureRegion[] walkUpFrames;
    private static TextureRegion[] walkDownFrames;
    private static SpriteBatch spriteBatch;
    private static TextureRegion currentFrame;

    private static float stateTime;


    private static Rectangle spriteBox;


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


    @Override
    public void render() {

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT); // #14
        stateTime += Gdx.graphics.getDeltaTime(); // #15
        spriteBatch.begin();
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            spriteBox.x += 2;
            currentFrame = walkRightAnim.getKeyFrame(stateTime, true);
        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            spriteBox.x -= 2;
            currentFrame = walkLeftAnim.getKeyFrame(stateTime, true);
        } else if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            spriteBox.y += 2;
            currentFrame = walkUpAnim.getKeyFrame(stateTime, true);
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            spriteBox.y -= 2;
            currentFrame = walkDownAnim.getKeyFrame(stateTime, true);
        } else {
            currentFrame = walkDownFrames[0];
        }
        spriteBatch.draw(currentFrame, spriteBox.x, spriteBox.y); // #17
        spriteBatch.end();
    }

    public static int getFrameCols() {
        return FRAME_COLS;
    }

    public static int getFrameRows() {
        return FRAME_ROWS;
    }

    public static Animation<TextureRegion> getWalkRightAnim() {
        return walkRightAnim;
    }

    public static Animation<TextureRegion> getWalkLeftAnim() {
        return walkLeftAnim;
    }

    public static Animation<TextureRegion> getWalkUpAnim() {
        return walkUpAnim;
    }

    public static Animation<TextureRegion> getWalkDownAnim() {
        return walkDownAnim;
    }

    public static Texture getWalkSheet() {
        return walkSheet;
    }

    public static TextureRegion[] getWalkRightFrames() {
        return walkRightFrames;
    }

    public static TextureRegion[] getWalkLeftFrames() {
        return walkLeftFrames;
    }

    public static TextureRegion[] getWalkUpFrames() {
        return walkUpFrames;
    }

    public static TextureRegion[] getWalkDownFrames() {
        return walkDownFrames;
    }

    public static SpriteBatch getSpriteBatch() {
        return spriteBatch;
    }

    public static TextureRegion getCurrentFrame() {
        return currentFrame;
    }

    public static float getStateTime() {
        return stateTime;
    }

    public static Rectangle getSpriteBox() {
        return spriteBox;
    }
}
