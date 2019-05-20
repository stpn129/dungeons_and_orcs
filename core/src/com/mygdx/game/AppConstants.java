package com.mygdx.game;

public class AppConstants {
    public static final int LOADING = 0;
    public static final int MENU = 1;
    public static final int GAME = 2;

    public static final float APP_WIDTH = 200;
    public static final float APP_HEIGHT = 400;

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
        LEFT_UP
    }

    public static enum Material {
        STEEL, WOOD, RUBBER, STONE
    }

    public static enum Shape {
        SQUARE, CIRCLE, PEGAGON, ARROW
    }

    public class LoadingQueue {
        public static final int IMAGE = 0;        // loading images
        public static final int FONT = 1;        // loading fonts
        public static final int PARTICLES = 2;        // loading particle effects
        public static final int SOUND = 3;        // loading sounds
        public static final int MUSIC = 4;        // loading music
        public static final int END = 5;        // loading music

    }
}
