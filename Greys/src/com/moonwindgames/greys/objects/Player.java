package com.moonwindgames.greys.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;

public class Player extends Sprite {
	private TiledMapTileLayer collisionLayer;
	private Vector2 velocity = new Vector2();
	private float gravity = 100*32;
	private float oldX, oldY;
	private float tileWidth = 32;
	private float tileHeight = 32;
	public boolean collisionX = false, collisionY = false;
	private boolean collisionroof = false;
	private float timeJumping = 0;
	public boolean canUseJump = true;

	
	public Player (Texture texture, TiledMapTileLayer collisionLayer){
		super (texture);
		this.collisionLayer = collisionLayer;
	}
	
	private void handletimeJumping (float deltaTime){
		timeJumping += deltaTime;
		if (timeJumping > 1.0f){
			canUseJump =false;
			setVelocityY(-getGravity());
		}
		if (collisionY && !collisionroof){
			timeJumping = 0.0f;
			canUseJump = true;
		}
		if (collisionroof){
			collisionroof = false;
		}
	}
	public float getVelocityX (){
		return this.velocity.x;
	}
	
	public float getVelocityY (){
		return this.velocity.y;
	}
	public void setVelocityX (float number){
		this.velocity.x = number;
		
	}
	public void setVelocityY (float number){
		this.velocity.y = number;
	}
	
	public void increaseVelocityX (float number){
		this.velocity.x += number;
	}
	public void decreaseVelocityX (float number){
		this.velocity.x -= number;
	}
	
	public void setPositionY (float position){
		this.setPosition (this.getX(), position);
	}
	
	public float getGravity () {
		return gravity;
	}
	
	private void rozamiento(){
		if (velocity.x > 0)
		this.decreaseVelocityX(10);
		if (velocity.x <0)
			this.increaseVelocityX(10);
	}
	public boolean setColisionX (String key){
		
		if (velocity.x<0){
			collisionX = collisionLayer.getCell((int)(getX()/tileWidth), (int) ((getY()+getHeight())/ tileHeight))
					.getTile().getProperties().containsKey(key);
			
			if (!collisionX)
			collisionX = collisionLayer.getCell((int)(getX()/tileWidth), (int) ((getY()+getHeight()/2)/ tileHeight))
					.getTile().getProperties().containsKey(key);
			if (!collisionX)
			collisionX = collisionLayer.getCell((int)(getX()/tileWidth), (int) ((getY())/ tileHeight))
					.getTile().getProperties().containsKey(key);
		}
		
		else if (velocity.x>0){
		
			collisionX = collisionLayer.getCell((int)((getX() + getWidth())/tileWidth), (int) ((getY()+getHeight())/ tileHeight))
					.getTile().getProperties().containsKey(key);
			if (!collisionX)
			collisionX = collisionLayer.getCell((int)((getX()+ getWidth())/tileWidth), (int) ((getY()+getHeight()/2)/ tileHeight))
					.getTile().getProperties().containsKey(key);
			if (!collisionX)
			collisionX = collisionLayer.getCell((int)((getX()+ getWidth())/tileWidth), (int) ((getY())/ tileHeight))
					.getTile().getProperties().containsKey(key);
			
		}

		else if (velocity.x == 0)
			collisionX = false;
		
		return collisionX;
	}
	
	
	public boolean setColisionY(String key){
		if (velocity.y < 0){
			canUseJump = false;
			
			collisionY = collisionLayer.getCell((int)(getX() /tileWidth), (int) ((getY())/ tileHeight))
					.getTile().getProperties().containsKey(key);
		
			if (!collisionY)
				
			collisionY = collisionLayer.getCell((int)((getX()+ getWidth()/2)/tileWidth), (int) ((getY())/ tileHeight))
					.getTile().getProperties().containsKey(key);
			
			if (!collisionY)
			
			collisionY = collisionLayer.getCell((int)((getX()+ getWidth())/tileWidth), (int) ((getY())/ tileHeight))
					.getTile().getProperties().containsKey(key);
			
		}
		else if (velocity.y > 0){
			
			collisionY = collisionLayer.getCell((int)(getX() /tileWidth), (int) ((getY()+getHeight())/ tileHeight))
					.getTile().getProperties().containsKey(key);
			if (!collisionY)
			collisionY = collisionLayer.getCell((int)((getX()+ getWidth()/2)/tileWidth), (int) ((getY()+getHeight()  )/ tileHeight))
					.getTile().getProperties().containsKey(key);
			if (!collisionY)
			collisionY = collisionLayer.getCell((int)((getX()+ getWidth())/tileWidth), (int) ((getY()+getHeight())/ tileHeight))
					.getTile().getProperties().containsKey(key);
		collisionroof = collisionY;	
		}
		
		return collisionY;
	}
	
	private void rozamientoaire(){
		velocity.y -=2.0f;
	}
	@Override 
	public void draw (SpriteBatch spritebatch){
		this.update(Gdx.graphics.getDeltaTime());
		super.draw(spritebatch);
	}
	
	private void update (float deltaTime){
		if(deltaTime < 0.05)
			velocity.y -= gravity * deltaTime;
		else
			velocity.y = 0;
		rozamientoaire();
		oldX = getX();
		oldY = getY();
		setX(getX()+ velocity.x*deltaTime);
		setColisionX ("colision");
		if (collisionX){
			setX (oldX);
			velocity.x = 0;
		}
		rozamiento();
		setY(getY()+velocity.y*deltaTime);
		setColisionY("colision");
		if(collisionY){
			setY(oldY);
			velocity.y = 0;
		}
		handletimeJumping (Gdx.graphics.getDeltaTime());
	}
	
	
}
