package com.dungeonsandorcs.rlgame.utils;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.gdx.graphics.Texture;
import com.dungeonsandorcs.rlgame.components.AnimationComponent;
import com.dungeonsandorcs.rlgame.components.B2dBodyComponent;
import com.dungeonsandorcs.rlgame.components.PlayerComponent;
import com.dungeonsandorcs.rlgame.components.ScoreComponent;
import com.dungeonsandorcs.rlgame.components.TextureComponent;

public class ComponentUtil {
    public static final ComponentMapper<AnimationComponent> ANIMATION_COMPONENT_MAPPER = ComponentMapper.getFor(AnimationComponent.class);
    public static final ComponentMapper<B2dBodyComponent> B_2_D_BODY_COMPONENT_MAPPER = ComponentMapper.getFor(B2dBodyComponent.class);
    public static final ComponentMapper<PlayerComponent> PLAYER_COMPONENT_MAPPER = ComponentMapper.getFor(PlayerComponent.class);
    public static final ComponentMapper<ScoreComponent> SCORE_COMPONENT_MAPPER = ComponentMapper.getFor(ScoreComponent.class);
    public static final ComponentMapper<TextureComponent> TEXTURE_COMPONENT_MAPPER = ComponentMapper.getFor(TextureComponent.class);
}
