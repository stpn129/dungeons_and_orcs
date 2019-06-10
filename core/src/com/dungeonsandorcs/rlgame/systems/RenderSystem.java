package com.dungeonsandorcs.rlgame.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.dungeonsandorcs.rlgame.AppConstants;
import com.dungeonsandorcs.rlgame.components.B2dBodyComponent;
import com.dungeonsandorcs.rlgame.components.PlayerComponent;
import com.dungeonsandorcs.rlgame.screens.GameScreen;
import com.dungeonsandorcs.rlgame.utils.ComponentUtil;
import com.dungeonsandorcs.rlgame.utils.EntityUtils;
import com.dungeonsandorcs.rlgame.utils.Objects;

import org.omg.CORBA.Bounds;

import sun.security.krb5.internal.APOptions;

import static com.dungeonsandorcs.rlgame.utils.Objects.spriteBatch;

public class RenderSystem extends IteratingSystem {
   public OrthogonalTiledMapRenderer renderer0;

   private static final float hero_width = 16f;
   private static final float hero_height = 16f;
   public static Vector2 cPos;
   public BitmapFont font;
   public String text;

    public RenderSystem( OrthogonalTiledMapRenderer renderer0) {
        super(Family.all(PlayerComponent.class,B2dBodyComponent.class).get());
        this.font = GameScreen.font;
        this.renderer0 = renderer0;
    }



    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        Batch batch = renderer0.getBatch();
        batch.begin();


        B2dBodyComponent b2dBodyComponent = ComponentUtil.B_2_D_BODY_COMPONENT_MAPPER.get(entity);
        Body body =  b2dBodyComponent.body;
        Sprite sprite = new Sprite(new Texture("Creatures/hero.png"));

        //enemies
        Sprite enemy = new Sprite(new Texture("Creatures/enemy1.png"));
        Sprite enemy0 = new Sprite(new Texture("Creatures/enemy2.png"));

        //quests
      //  Sprite text = new Sprite(new Texture("maps/Tilemap/text.png"));
        Sprite diamond = new Sprite(new Texture("Creatures/diamond.png"));
        Sprite stranger = new Sprite(new Texture("Creatures/stranger.png"));

        enemy.setPosition(528 ,48);
        enemy0.setPosition(496,48);
        diamond.setPosition(240,384);
        stranger.setPosition(576,112);


        Vector2 pos = new Vector2();
         cPos = new Vector2();

        pos.set(body.getPosition());

        cPos.x = pos.x - hero_width/2;
        cPos.y = pos.y - hero_height/2;
        sprite.setPosition(cPos.x, cPos.y);
        float rotation = (float) Math.toDegrees(body.getAngle());
        sprite.setRotation(rotation);
        if (RenderSystem.cPos.x ==512&&RenderSystem.cPos.y == 64){
            AppConstants.isQuest1Started = true;
        }else if(cPos.x==240&&cPos.y == 384){
            AppConstants.isDiamondCatched = true;
        }else if (AppConstants.isDiamondCatched && cPos.x==576 && cPos.y == 96){
            AppConstants.isIsQuest1Ended = true;
        }

//        batch.draw(text,0,0);
        if (AppConstants.isQuest1Started && !AppConstants.isIsQuest1Ended&& !AppConstants.isDiamondCatched){
            batch.draw(diamond,240,384);
        }
        batch.draw(sprite,cPos.x,cPos.y);
        batch.draw(enemy,528,48);
        batch.draw(enemy0,496,48);

        batch.draw(stranger,576,112);
        batch.end();
        //System.out.println(cPos.x+ " " + cPos.y);
    }

}
