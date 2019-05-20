package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TiledDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.AppConstants;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.managers.Assets;

import static com.mygdx.game.AppConstants.LoadingQueue.END;
import static com.mygdx.game.AppConstants.LoadingQueue.FONT;
import static com.mygdx.game.AppConstants.LoadingQueue.MUSIC;
import static com.mygdx.game.AppConstants.LoadingQueue.PARTICLES;
import static com.mygdx.game.AppConstants.LoadingQueue.SOUND;

public class LoadingScreen implements Screen {
    private MyGdxGame parent;
    private TextureAtlas.AtlasRegion title;
    private Animation flameAnimation;

    private int currentLoadingStage = 0;

    // timer for exiting loading screen
    public float countDown = 0.1f;
    private TextureAtlas.AtlasRegion dash;
    private Stage stage;
    private TextureAtlas.AtlasRegion copyright;
    private Table loadingTable;
    private TextureAtlas.AtlasRegion background;


    public LoadingScreen(MyGdxGame game) {
        parent = game;
        stage = new Stage(new ScreenViewport());

        loadUI();

        Assets.getInstance()
                .loadTextures();
        System.out.println("Loading images....");
    }

    private void loadUI() {
        // load loading images and wait until finished
        Assets.getInstance()
                .loadTextures();
        Assets.getInstance()
                .loadingFinished();

        // get images used to display loading progress
        TextureAtlas atlas = Assets.getInstance().getAsset(Assets.Atlas.LOADING, TextureAtlas.class);
        title = atlas.findRegion(Assets.UI.TITLE);
        dash = atlas.findRegion(Assets.UI.DASH);
        background = atlas.findRegion(Assets.UI.BACKGROUND);
        copyright = atlas.findRegion(Assets.UI.COPYRIGHT);
        flameAnimation = new Animation(0.07f, atlas.findRegions("flames/flames"), Animation.PlayMode.LOOP);
    }

    @Override
    public void show() {

        Image titleImage = new Image(title);
        Image copyrightImage = new Image(copyright);

        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(false);
        table.setBackground(new TiledDrawable(background));

        loadingTable = new Table();
        loadingTable.add(new LoadingBarPart(dash, flameAnimation));
        loadingTable.add(new LoadingBarPart(dash, flameAnimation));
        loadingTable.add(new LoadingBarPart(dash, flameAnimation));
        loadingTable.add(new LoadingBarPart(dash, flameAnimation));
        loadingTable.add(new LoadingBarPart(dash, flameAnimation));
        loadingTable.add(new LoadingBarPart(dash, flameAnimation));
        loadingTable.add(new LoadingBarPart(dash, flameAnimation));
        loadingTable.add(new LoadingBarPart(dash, flameAnimation));
        loadingTable.add(new LoadingBarPart(dash, flameAnimation));
        loadingTable.add(new LoadingBarPart(dash, flameAnimation));


        table.add(titleImage).align(Align.center).pad(10, 0, 0, 0).colspan(10);
        table.row(); // move to next row
        table.add(loadingTable).width(400);
        table.row();
        table.add(copyrightImage).align(Align.center).pad(200, 0, 0, 0).colspan(10);

        stage.addActor(table);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (Assets.getInstance().update()) { // Load some, will return true if done loading
            currentLoadingStage += 1;
            if (currentLoadingStage <= 5) {
                loadingTable.getCells().get((currentLoadingStage - 1) * 2).getActor().setVisible(true);
                loadingTable.getCells().get((currentLoadingStage - 1) * 2 + 1).getActor().setVisible(true);
            }
            switch (currentLoadingStage) {
                case FONT:
                    System.out.println("Loading fonts....");
                    Assets.getInstance()
                            .loadFonts();
                    break;
                case PARTICLES:
                    System.out.println("Loading Particle Effects....");
                    Assets.getInstance()
                            .loadParticles();
                    break;
                case SOUND:
                    System.out.println("Loading Sound....");
                    Assets.getInstance()
                            .loadSounds();
                    break;
                case MUSIC:
                    System.out.println("Loading music....");
                    Assets.getInstance()
                            .loadMusic();
                    break;
                case END:
                    System.out.println("Finished");
                    break;
            }
            if (currentLoadingStage > 5) {
                countDown -= delta;
                currentLoadingStage = 5;
                if (countDown < 0) {
                    parent.changeScreen(AppConstants.MENU);
                }
            }
        }

        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
        stage.dispose();
    }

    class LoadingBarPart extends Actor {

        private TextureAtlas.AtlasRegion image;
        private Animation flameAnimation;
        private float stateTime = 0f;
        private TextureRegion currentFrame;


        public LoadingBarPart(TextureAtlas.AtlasRegion ar, Animation an) {
            super();
            image = ar;
            flameAnimation = an;
            this.setWidth(30);
            this.setHeight(25);
            this.setVisible(false);
        }

        @Override
        public void draw(Batch batch, float parentAlpha) {
            super.draw(batch, parentAlpha);
            batch.draw(image, getX(), getY(), 30, 30);
            batch.setBlendFunction(GL20.GL_SRC_ALPHA, GL20.GL_ONE);
            batch.draw(currentFrame, getX() - 5, getY(), 40, 40);
            batch.setBlendFunction(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);

        }

        @Override
        public void act(float delta) {
            super.act(delta);
            stateTime += delta; // Accumulate elapsed animation time
            currentFrame = (TextureRegion) flameAnimation.getKeyFrame(stateTime, true);
        }

    }
}

