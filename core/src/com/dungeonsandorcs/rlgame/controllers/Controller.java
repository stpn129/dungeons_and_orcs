package com.dungeonsandorcs.rlgame.controllers;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.dungeonsandorcs.rlgame.objects.Animator;




public class Controller extends ApplicationAdapter {

    private Animation<TextureRegion> walkRightAnim;
    private Animation<TextureRegion> walkLeftAnim;
    private Animation<TextureRegion> walkUpAnim;
    private Animation<TextureRegion> walkDownAnim;


    private TextureRegion[] walkDownFrames;
    private SpriteBatch spriteBatch;

    private TextureRegion currentFrame;
    private float stateTime;

    private Rectangle spriteBox;

    private Animator animator;

    public Controller(Animator animator) {
        this.animator = animator;
    }

    @Override
    public void create() {

        spriteBatch        = animator.getSpriteBatch();

        walkRightAnim      = animator.getWalkRightAnim();
        walkLeftAnim       = animator.getWalkLeftAnim();
        walkUpAnim         = animator.getWalkUpAnim();
        walkDownAnim       = animator.getWalkDownAnim();

        walkDownFrames     = animator.getWalkDownFrames();
        stateTime          = animator.getStateTime();
        currentFrame       = animator.getCurrentFrame();

        spriteBox          = animator.getSpriteBox();



    }

    @Override
    public void render() {

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT); // #14
        stateTime += Gdx.graphics.getDeltaTime(); // #15
        spriteBatch.begin();
if (check()){
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
}
        spriteBatch.draw(currentFrame, spriteBox.x, spriteBox.y); // #17
        spriteBatch.end();
    }
    private Boolean check(){
        return true;
    }
}
