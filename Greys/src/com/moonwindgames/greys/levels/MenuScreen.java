package com.moonwindgames.greys.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.moonwindgames.greys.Greys_Main_Handler;

public class MenuScreen implements Screen {
	private Stage stage;
	private Skin skin;
	private Image imgLogo;
	private Image imgMoon;
	private Image imgPlay;
	private Greys_Main_Handler game;
	private boolean title = false;
	private float contador = 0;
	
	
	public MenuScreen (Greys_Main_Handler game){
		this.game = game;
	}

	@Override
	public void render(float delta) {
		contador+=delta;
	    Gdx.gl.glClearColor (224.0f, 224.0f, 224.0f,0.5f);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		stage.act(delta);
		stage.draw();
		if (Gdx.input.isKeyPressed(Keys.SPACE)|| Gdx.input.isKeyPressed(Keys.ENTER)){
			game.setScreen(new Level(this.game));
		}
		if (contador>3 && !title){
			title = true;
			rebuildStage();
			contador =0;
		}
		
	}

	private void rebuildStage() {
		skin = new Skin (Gdx.files.internal("ui.json"), new TextureAtlas ("asset.pack"));
		if (title){
	        Table layerLogos = buildLogosLayer();
			stage.clear();
			Stack stack = new Stack();
			stage.addActor(stack);
			stack.setSize(Gdx.app.getGraphics().getWidth(), Gdx.app.getGraphics().getHeight());
			stack.add(layerLogos);
		}
		else{
			Table layerMoon = buildMoonLayer();
			stage.clear();
			Stack stack = new Stack();
			stage.addActor(stack);
			stack.setSize(Gdx.app.getGraphics().getWidth(), Gdx.app.getGraphics().getHeight());
			stack.add(layerMoon);
		}
		
	}
	

	private Table buildMoonLayer() {
		Table layer = new Table();
		layer.top().center();
		imgMoon = new Image (skin, "moon");
		layer.add(imgMoon);
		return layer;
		
	}

	

	private Table buildLogosLayer() {
		Table layer = new Table();
		layer.top().top();
		imgLogo = new Image (skin,"title");
		layer.add(imgLogo);
		layer.row().expandY();
		imgPlay = new Image(skin,"play");
		layer.add(imgPlay);
		return layer;
	}

	@Override
	public void resize(int width, int height) {
		stage.setViewport(width, height);
		
	}

	@Override
	public void show() {
		stage = new Stage();
		rebuildStage();
	}

	@Override
	public void hide() {
		stage.dispose();
		skin.dispose();
		
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
