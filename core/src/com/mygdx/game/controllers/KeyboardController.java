package com.mygdx.game.controllers;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

public class KeyboardController extends InputAdapter {
    private boolean left;
    private boolean right;
    private boolean up;
    private boolean down;

    @Override
    public boolean keyDown(int keycode) {
        boolean keyProcessed = false;
        switch (keycode) {
            case Input.Keys.UP:
            case Input.Keys.W:
                if (!down)
                    up = true;
                keyProcessed = true;
                break;
            case Input.Keys.RIGHT:
            case Input.Keys.D:
                if (!left)
                    right = true;
                keyProcessed = true;
                break;
            case Input.Keys.DOWN:
            case Input.Keys.S:
                if (!up)
                    down = true;
                keyProcessed = true;
                break;
            case Input.Keys.LEFT:
            case Input.Keys.A:
                if (!right)
                    left = true;
                keyProcessed = true;
                break;
        }
        return keyProcessed;
    }

    @Override
    public boolean keyUp(int keycode) {
        boolean keyProcessed = false;
        switch (keycode) {
            case Input.Keys.UP:
            case Input.Keys.W:
                up = false;
                keyProcessed = true;
                break;
            case Input.Keys.RIGHT:
            case Input.Keys.D:
                right = false;
                keyProcessed = true;
                break;
            case Input.Keys.DOWN:
            case Input.Keys.S:
                down = false;
                keyProcessed = true;
                break;
            case Input.Keys.LEFT:
            case Input.Keys.A:
                left = false;
                keyProcessed = true;
                break;
        }
        return keyProcessed;
    }

    public boolean isUp() {
        return up;
    }

    public boolean isRight() {
        return right;
    }

    public boolean isDown() {
        return down;
    }

    public boolean isLeft() {
        return left;
    }
}
