package com.moonwindgames.greys.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Animator {
	private static final int Frames = 10;
	private Animation walkAnimation;
	private Texture walkSheet;
	private TextureRegion[] walkFrames;
	private TextureRegion currentFrame;
	float stateTime;
	private Player player;
	
	public Animator (Player player){
		
		walkSheet = new Texture (Gdx.files.internal("walking.png"));
		TextureRegion [][] tmp = TextureRegion.split(walkSheet, 32, 32);
		walkFrames = new TextureRegion[10];
		int index = 0;
		for (int i=0; i<2;i++){
			for (int j = 0; j<5; j++){
				walkFrames[index++] = tmp[i][j];
			}
		}
		walkAnimation = new Animation (0.2f, walkFrames);
		stateTime = 0f;
	}
	public void update(float deltaTime){
		stateTime+= deltaTime;
		currentFrame = walkAnimation.getKeyFrame(stateTime, true);
		player.setRegion (currentFrame);
	}
}
