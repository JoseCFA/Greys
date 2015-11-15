package com.moonwindgames.greys;


import com.badlogic.gdx.Game;
import com.moonwindgames.greys.levels.MenuScreen;

public class Greys_Main_Handler extends Game {

	@Override
	public void create() {
		this.setScreen(new MenuScreen(this));
		
	}
	
}
