package com.dungeonsandorcs.rlgame.utils;

import com.badlogic.ashley.core.ComponentMapper;
import com.dungeonsandorcs.rlgame.components.AnimationComponent;

public class ComponentUtil {
    public static final ComponentMapper<AnimationComponent> CONE_LIGHT_MAPPER = ComponentMapper.getFor(AnimationComponent.class);

}
