package com.moonwindgames.greys;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Greys";
		cfg.useGL20 = true;
		cfg.width = 800;
		cfg.height = 780;
		
		new LwjglApplication(new Greys_Main_Handler(), cfg);
	}
}
