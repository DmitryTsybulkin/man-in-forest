package com.swallow.wolf;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.swallow.wolf.menus.MainMenu;

public class Main extends Game {

	public static final int WIDTH = 800;
	public static final int HEIGHT = 480;

	public SpriteBatch batch;
	public BitmapFont font;
	public Stage stage;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont();
		stage = new Stage();
		this.setScreen(new MainMenu(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		font.dispose();
	}
}
