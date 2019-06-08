package com.dungeonsandorcs.rlgame;

public class AppConstants {
    public static final int LOADING = 0;
    public static final int MENU = 1;
    public static final int GAME = 2;

    public static final float APP_WIDTH = 200;
    public static final float APP_HEIGHT = 400;
    public static final short MARIO_BIT = 2;
    public static final short BRICK_BIT = 8;
    public static final float MOVETOCELL_TIME = 1000f;
    public static final float EPS = 0.1f;

    //TODO: remove testing field
    public static boolean testing = true;

    public enum Direction {
        UP,
        UP_LEFT,
        UP_RIGHT,
        RIGHT,
        RIGHT_UP,
        RIGHT_DOWN,
        DOWN,
        DOWN_RIGHT,
        DOWN_LEFT,
        LEFT,
        LEFT_DOWN,
        LEFT_UP,
        NONE
    }

    public static enum Material {
        STEEL, WOOD, RUBBER, STONE
    }

    public static enum Shape {
        SQUARE, CIRCLE, PEGAGON, ARROW
    }

    //Objects
    public static float unitScale = 1f;
    public static float viewportWidth = 16;
    public static float viewportHeight = 16;

    public static float SPEED = 16f;
    public static float TIME = 0.2f;
    public static boolean isQuest1Started = false;
    public static boolean isIsQuest1Ended = false;
    public static boolean isDiamondCatched = false;
   public static String questStarted = "quest 1 started: find a diamond, near the forest.";
    public static String diamondCatched = "quest 1 : the oldman will take a diamond.";
    public static String questEnded = "quest 1 is finished: thanks adventurer... ";
    public static String messageDemo = "it was a demo of my game, thanks for watching";




}