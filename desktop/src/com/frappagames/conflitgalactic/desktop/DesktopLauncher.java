package com.frappagames.conflitgalactic.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.frappagames.conflitgalactic.ConflitGalactic;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.width = 860;
		config.height = 540;

		new LwjglApplication(new ConflitGalactic(), config);
	}
}
