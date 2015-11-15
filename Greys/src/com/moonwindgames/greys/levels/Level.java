package com.moonwindgames.greys.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.moonwindgames.greys.Greys_Main_Handler;
import com.moonwindgames.greys.objects.Animator;
import com.moonwindgames.greys.objects.GameLogic;
import com.moonwindgames.greys.objects.Player;

public class Level implements Screen {
	private TiledMap map;
	private OrthogonalTiledMapRenderer renderer;
	public OrthographicCamera camera;
	public Player player;
	private Texture startSprite;
	private Animator animator;
	private GameLogic logic;
	private Music music;
	private int secretcounter = 0;
	private BitmapFont font;
	private boolean one=false, two=false, three=false, four=false, five=false, six=false, seven=false, eight=false,nine=false,ten=false;
	private Greys_Main_Handler game;
	
	public Level (Greys_Main_Handler game){
		this.game = game;
	}
	
	@Override
	public void render(float delta) {
		
		Gdx.gl.glClearColor(0, 0, 0,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.position.x = player.getX()+ player.getOriginX();
		camera.position.y = player.getY() + player.getOriginY()+ (4*32);
		camera.update();
		logic.handleInputGame(delta, this);
		renderer.setView(camera);
		renderer.render();
		animator.update(delta);
		renderer.getSpriteBatch().begin();
			font.drawMultiLine(renderer.getSpriteBatch(), "Secrets: " + secretcounter + " /10", player.getX()-32, player.getY() + Gdx.app.getGraphics().getHeight()-440);
			font.drawMultiLine(renderer.getSpriteBatch(), "He... is dead?", 34*32, 430*32);
			font.drawMultiLine(renderer.getSpriteBatch(), "What...?", 10*32, 418*32 );
			font.drawMultiLine(renderer.getSpriteBatch(), "See something?", 29*32,360*32);
			font.drawMultiLine(renderer.getSpriteBatch(), "Soul states", 3*32,386*32 );
			font.drawMultiLine(renderer.getSpriteBatch(), "Clearer here...", 6*32, 317*32);
			font.drawMultiLine(renderer.getSpriteBatch(), "I thought people only...", 20*32, 317*32);
			font.drawMultiLine(renderer.getSpriteBatch(), "You remembered some stairs...", 11*32, 294*32);
			font.drawMultiLine(renderer.getSpriteBatch(), "...?", 24*32, 257*32);
			font.drawMultiLine(renderer.getSpriteBatch(), "Christine's hearth", 33*32,194*32 );
			player.draw(renderer.getSpriteBatch());
		renderer.getSpriteBatch().end();
		watchSecrets();
		
	}
	private void watchSecrets(){
		if (player.getY() < (460*32) ){
		if ((this.one==false) && (player.getX() <(42*32)) && ((player.getX()>(39*32))) && (player.getY() <(456*32)) && (player.getY()> (454*32)) ){
			one = true;
			secretcounter++;
			}
		
		}
		
		if(player.getY() <(435*32)){
			if((this.two == false) && (player.getX() < (39*32)) && (player.getX() > (35*32)) && (player.getY() <(430*32)) && (player.getY() > (426*32)) ){
				two = true;
				secretcounter++;
			}
		}
		
		if (player.getY() < (420*32)){
			if ((this.three == false) && (player.getX() < (14*32)) && (player.getX()> (10*32)) && (player.getY() < (418*32)) && (player.getY() > (414*32))){
				three = true;
				secretcounter++;
			}
		}
		if (player.getY() < (390*32)){
			if ((this.four == false) && (player.getX() < (7*32)) && (player.getX() > (3*32)) && (player.getY() < (385*32)) && (player.getY() > (381*32))) {
				four = true;
				secretcounter++;
			}
		
		}
		if (player.getY() < (365*32)){
			if ((this.five == false) && (player.getX() < (3*32)) && (player.getX()> (0*32)) && (player.getY() < (360*32)) && (player.getY() > (355*32))){
				five = true;
				secretcounter++;
			}
		}
		if (player.getY() < (320*32)){
			if ((this.six == false) && (player.getX()<(41*32)) && (player.getX()> (35*32)) && (player.getY()< (317*32)) && (player.getY() > (312*32))){
				six = true;
				secretcounter++;
			}
		}
		if (player.getY() < (312*32)){
			if ((this.seven == false) && (player.getX()< (9*32)) && (player.getX()> (5*32)) && (player.getY()< (309*32)) && (player.getY() > (305*32))){
				seven = true;
				secretcounter++;
			}
		}
		if (player.getY()<(280*32)){
			if ((this.eight==false) && (player.getX()<(42*32)) && (player.getX() > (38*32)) && (player.getY()<(277*32)) && (player.getY()>(273*32))){
				eight = true;
				secretcounter++;
			}
		
		}
		if (player.getY() <(248*32)){
			if ((this.nine==false)&&(player.getX()<(4*32)) && (player.getX() > (0*32)) && (player.getY()<(244*32)) && (player.getY()>(240*32))){
				nine = true;
				secretcounter++;
			}
		}
		
		if (player.getY() <(200*32)){
			if ((this.ten ==false) && (player.getX()<(37*32)) && (player.getX()>(33*32)) && (player.getY() <(194*32)) && (player.getY()> (190*32))){
				ten = true;
				secretcounter++;
			}
		
		}
		if (player.getY()< (190*32)){
			if ((player.getX()< (50*32)) && (player.getX()>(46*32)) && (player.getY()<(188*32)) && (player.getY() > (184*32))){
				if (secretcounter == 10){
					this.game.setScreen(new GoodEnd());
				}
				else{
					this.game.setScreen(new BadEnd());
				}
			}
		}
			
	}
	@Override
	public void resize(int width, int height) {
		
		
	}

	@Override
	public void show() {
		music = Gdx.audio.newMusic(Gdx.files.internal ("background_sound.mp3"));
		music.setLooping(true);
		music.play();
		font = new BitmapFont (Gdx.files.internal("PixelFont.fnt"));
		logic = new GameLogic ();
		map = new TmxMapLoader().load("map/map.tmx");
		renderer = new OrthogonalTiledMapRenderer (map);
		camera = new OrthographicCamera();
		camera.setToOrtho(false);
		player = new Player (new Texture (Gdx.files.internal ("texture.png")), (TiledMapTileLayer)map.getLayers().get("Fondo"));
		player.setPosition(11*32, 489*32);
		camera.viewportHeight = 32*14;
		camera.viewportWidth = 32*14;
		animator = new Animator(this.player);
		
	}

	@Override
	public void hide() {
		
		
	}

	@Override
	public void pause() {
		
		
	}

	@Override
	public void resume() {
		
		
	}

	@Override
	public void dispose() {
		
		
	}

}
