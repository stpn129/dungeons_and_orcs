package com.dungeonsandorcs.rlgame.objects;

import com.badlogic.gdx.physics.box2d.Body;
import com.dungeonsandorcs.rlgame.objects.Animator;



public class Player {
    private Animator animator;
    private int playerX;
    private int playerY;
    private Body body; //???


    public int getPlayerX() {
        return playerX;
    }

    public void setPlayerX(int playelrX) {
        this.playerX = playerX;
    }

    public int getPlayerY() {
        return playerY;
    }

    public void setPlayerY(int playerY) {
        this.playerY = playerY;
    }
}
