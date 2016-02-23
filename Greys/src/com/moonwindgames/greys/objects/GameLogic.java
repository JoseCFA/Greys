package com.moonwindgames.greys.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.moonwindgames.greys.levels.Level;

public class GameLogic extends InputAdapter {
	public GameLogic(){
		
	}
	private void init(){
		Gdx.input.setInputProcessor(this);
		Gdx.input.setCatchBackKey(true);
	}
	
	public void handleInputGame (float deltaTime, Level level){
		if (Gdx.input.isKeyPressed(Keys.SPACE)){
			if (level.player.canUseJump){
				level.player.setVelocityY(950);
				
			}
			level.player.canUseJump = false;
		}
		if (Gdx.input.isKeyPressed(Keys.D)|| (Gdx.input.isKeyPressed(Keys.RIGHT))){
			if (level.player.collisionY)
				level.player.setVelocityX(200);
			else{
				level.player.setVelocityX(200);
			}
			
		
	}
		if(Gdx.input.isKeyPressed(Keys.A) || (Gdx.input.isKeyPressed(Keys.LEFT))){
			if(level.player.collisionY)
				level.player.setVelocityX(-200);
			else{
				level.player.setVelocityX (-200);
			}
		}
		
		
}
}
