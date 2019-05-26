package com.dungeonsandorcs.rlgame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.dungeonsandorcs.rlgame.DungeonGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 400;
		config.height = 400;
		config.resizable = false;
		config.title = "Dungeons&Orcs";
		new LwjglApplication(new DungeonGame(), config);
	}
}
