package com.moonwindgames.greys.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BadEnd implements Screen{

	//Hola

	private SpriteBatch batch;
	private BitmapFont font;
	private OrthographicCamera camera;
	@Override
	public void render(float delta) {
		
		Gdx.gl.glClearColor (255.0f, 255.0f, 255.0f, 1.0f);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		batch.begin();
		font.drawMultiLine(batch, "Maybe with all secrets...", 150, 600);
		font.drawMultiLine(batch, "The game is about a friend", 150, 500);
		font.drawMultiLine(batch, "Press Enter to quit the game", 150, 400);
		font.drawMultiLine(batch, "Thanks for playing! :)", 150, 300);
		
		batch.end();
		if (Gdx.input.isKeyPressed(Keys.ENTER)){
			Gdx.app.exit();
		}
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		batch = new SpriteBatch();
		font = new BitmapFont(Gdx.files.internal ("PixelFont.fnt"));
		camera = new OrthographicCamera();
        camera.position.x = Gdx.app.getGraphics().getWidth()/2;
		camera.position.y = Gdx.app.getGraphics().getHeight()/2;
		camera.update();
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
