package com.hello;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MenuScreen implements Screen{
	 private final Hello game;
	 
	 private SpriteBatch batch;
	 private Texture img;
		
	 private Person mainCharacter;
	 private NPC[] npc;
	 
	 private Building[] b;
	 private Building c;
	 
	 private Room r1;
	 
	 private RoomScreen room1;
	
	 private float totaltime = 0;
	 
	 private BitmapFont font;
	 
	 private String time = "";
	 private String second = "";
	 
	public MenuScreen(Hello game,int t)
	{
		this.game = game;
		
		
		
		totaltime = t;
		mainCharacter = new Person("Bob","a.png","a.png",
			                       "a.png","a.png",105,170,20,20);
		b = new Building[2];
		npc = new NPC[1];
		
		npc[0] = new NPC("Pizza","a.png","a.png","a.png","a.png",105,170,500,20);
		
		b[0] = new Building("b","b.png",420,400,650,100);
		b[1] = new Building("c","b.png",420,400,250,100);
		
		r1 = new Room("r1","room1.png",1280,720);
		
		mainCharacter.setBuilding(b);
		mainCharacter.setNpc(npc);
		
		font = new BitmapFont();
		font.setColor(Color.BLACK);
		
		room1 = new RoomScreen(game,this,r1);
	}
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		float deltaTime = Gdx.graphics.getDeltaTime();
		
		
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		game.batch.begin();
	
		b[0].show(game);
		mainCharacter.show(game);
		b[1].show(game);
		//npc[0].show(game);
		
		font.draw(game.batch, time+second, 300, 300);
		
		
		game.batch.end();
		
		mainCharacter.walk();
		mainCharacter.respond();
		mainCharacter.enterBuilding(game,room1,totaltime);
			

			
			totaltime += deltaTime;
			int minutes = ((int)totaltime) / 60;
		    int seconds = ((int)totaltime) % 60;
		    
		    if(minutes<10)
			{
				time = "0"+Integer.toString(minutes)+":";
			}
		    else
		    {
		    	time = Integer.toString(minutes)+":";
		    }
		    if(seconds<10)
		    {
		    	second = "0"+Integer.toString(seconds);
		    }
		    else
		    {
		    	second = Integer.toString(seconds);
		    }
	}

	public float getTotaltime() {
		return totaltime;
	}
	public void setTotaltime(float totaltime) {
		this.totaltime = totaltime;
	}
	@Override
	public void resize(int width, int height) {
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
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		for(int i = 0;i<b.length;i++)
		{
			b[i] = null;
			
		}
	}

}
