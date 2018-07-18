package com.frappagames.conflitgalactic.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.frappagames.conflitgalactic.ConflitGalactic;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.width = 960;
		config.height = 720;

		new LwjglApplication(new ConflitGalactic(), config);
	}
}
