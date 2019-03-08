package com.dungeonsandorcs.rlgame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.dungeonsandorcs.rlgame.DungeonGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1024;
		config.height = 1024;
		config.resizable = false;
		new LwjglApplication(new DungeonGame(), config);

		

	}
}
