package com.mygdx.game.managers;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.SkinLoader;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Assets {
    private final AssetManager manager;
    private static Assets instance;

    public static class Atlas {
        public static final String DESERT = "atlas/desert.tmx";
        public static final String LOADING = "images/loading.atlas";
        public static final String UI = "images/loading.atlas";
    }

    public static class Music {
        public static final String PLAYING = "music/Rolemusic_-_pl4y1ng.mp3";
    }

    public static class Sound {
        public static final String BOING = "sounds/boing.wav";
        public static final String PING = "sounds/ping.wav";

    }

    public static class UI {
        public static final String SKIN = "skin/glassy-ui.json";
        public static final String TITLE = "staying-alight-logo";
        public static final String DASH = "loading-dash";
        public static final String BACKGROUND = "flamebackground";
        public static final String COPYRIGHT = "copyright";
    }

    private Assets() {
        manager = new AssetManager();
    }

    public static Assets getInstance() {
        if (instance == null) {
            instance = new Assets();
            return instance;
        } else {
            return instance;
        }
    }

    public void loadTextures() {
        manager.setLoader(TiledMap.class, new TmxMapLoader(new InternalFileHandleResolver()));
        manager.load(Atlas.DESERT, TiledMap.class);
        manager.load(Atlas.LOADING, TextureAtlas.class);
    }

    public void loadSkin() {
        SkinLoader.SkinParameter params = new SkinLoader.SkinParameter(Atlas.UI);
        manager.load(UI.SKIN,
                Skin.class,
                params);
    }

    public void loadMusic() {
        manager.load(Music.PLAYING, com.badlogic.gdx.audio.Music.class);
    }

    public void loadSounds() {
        manager.load(Sound.BOING, com.badlogic.gdx.audio.Sound.class);
        manager.load(Sound.PING, com.badlogic.gdx.audio.Sound.class);

    }

    public void loadFonts() {
        // TODO: 17.04.2019 add fonts
    }

    public void loadParticles() {
        // TODO: 17.04.2019 add particles
    }

    public boolean update() {
        return manager.update();
    }

    public void loadingFinished() {
        manager.finishLoading();
    }

    public <T> T getAsset(String fileName, Class<T> type) {
        return manager.get(fileName, type);
    }
}
