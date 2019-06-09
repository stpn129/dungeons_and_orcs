package com.dungeonsandorcs.rlgame.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.dungeonsandorcs.rlgame.AppConstants;
import com.dungeonsandorcs.rlgame.components.B2dBodyComponent;
import com.dungeonsandorcs.rlgame.components.PlayerComponent;
import com.dungeonsandorcs.rlgame.screens.GameScreen;
import com.dungeonsandorcs.rlgame.utils.ComponentUtil;
import com.dungeonsandorcs.rlgame.utils.Objects;

public class PlayerControlSystem extends IteratingSystem {
    public Button up;
    public Button down;
    public Button right;
    public  Button left;
    private Stage stage;


    public PlayerControlSystem() {
        super(Family.all(PlayerComponent.class).get());
        this.up = GameScreen.up;
        this.down = GameScreen.down;
        this.right = GameScreen.right;
        this.left = GameScreen.left;
        stage = new Stage(new ScreenViewport());
        Skin skin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));

        up = new Button(skin);
        down = new Button(skin);
        right = new Button(skin);
        left = new Button(skin);


        up.setSize(10,10);
        up.setPosition(300,200);
        up.addListener(new ClickListener());
        stage.addActor(up );

        down.setSize(10,10);
        down.setPosition(300,100);
        down.addListener(new ClickListener()); //действие при нажатии
        stage.addActor(down );

        right.setSize(10,10);
        right.setPosition(250,150);
        right.addListener(new ClickListener()); //действие при нажатии
        stage.addActor(right );

        left.setSize(10,10);
        left.setPosition(350,150);
        stage.addActor(left );
        right.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                move(new Vector2(0, AppConstants.SPEED / AppConstants.TIME));

            }
        });
        left.addListener(new ClickListener());
        down.addListener(new ClickListener());
        up.addListener(new ClickListener());



    }

    private float elapsed;
    private boolean mustRound = false;
    private Vector2 toP = new Vector2();

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        elapsed += deltaTime;
        B2dBodyComponent b2dBodyComponent = ComponentUtil.B_2_D_BODY_COMPONENT_MAPPER.get(entity);
        Body body = b2dBodyComponent.body;

        if (elapsed <= AppConstants.TIME) {
            body.setLinearVelocity(toP);
        } else {
            if (mustRound) {
                b2dBodyComponent.body.setTransform(norm(body.getPosition()), 0);
                mustRound = false;
            }
            body.setLinearVelocity(0, 0);
            if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
                move(new Vector2(0, AppConstants.SPEED / AppConstants.TIME));
            }

            if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
                move(new Vector2(0, -AppConstants.SPEED / AppConstants.TIME));
            }

            if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
                move(new Vector2(AppConstants.SPEED / AppConstants.TIME, 0));
            }

            if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
                move(new Vector2(-AppConstants.SPEED / AppConstants.TIME, 0));
            }





        }

        // TODO: 2019-05-30 Remove after testing
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.O)) {
            System.out.println("Reset");
            b2dBodyComponent.body.setTransform(520f, 8f, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.E)) {
            Objects.camera.zoom += 0.3f;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.Q)) {
            Objects.camera.zoom -= 0.3f;
        }
    }

    private void move(Vector2 direct) {
        elapsed = 0;
        toP = direct;
        mustRound = true;
    }

    //-8 or 8 because start coordinates are not do not divide integrally by 16
    private Vector2 norm(Vector2 position) {
        return new Vector2(round(position.x - 8) + 8, round(position.y - 8) + 8);
    }

    private float round(float i) {
        return Math.round(i / AppConstants.SPEED) * AppConstants.SPEED;
    }
}
