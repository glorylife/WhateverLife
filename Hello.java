package com.hello;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Hello extends Game {
	SpriteBatch batch;
	MenuScreen a;
	@Override
	public void create () {
		batch = new SpriteBatch();
		a = new MenuScreen(this,0);
		
		 this.setScreen(a);
	}

	@Override
	public void render () {
		
		super.render();
		
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		//img.dispose();
	}
}
