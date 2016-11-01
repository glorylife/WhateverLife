package com.hello;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.Screen;

public class RoomScreen implements Screen{
	private final Hello game;
	private MenuScreen parent;
	
	private Person a;
	
	private Room r1;
	private BitmapFont font;
	
	private float totaltime;
	 private String time = "";
	 private String second = "";
	
	public float getTotaltime() {
		return totaltime;
	}
	public void setTotaltime(float totaltime) {
		this.totaltime = totaltime;
	}
	public RoomScreen(Hello game,MenuScreen parent,Room r12)
	{
		this.game = game;
		this.parent = parent;
		a = new Person("Bob","a.png",
				"a.png","a.png","a.png",105,170,640-(200/2),0);
		r1 = r12;
		
		font = new BitmapFont();
		font.setColor(Color.BLACK);
		
		
	}
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		float deltaTime = Gdx.graphics.getDeltaTime();
		game.batch.begin();
		game.batch.draw(r1.getPicture(),r1.getPrec().x,r1.getPrec().y);
	    a.show(game);
	    font.draw(game.batch, time+second, 300, 300);
		game.batch.end();
		
		a.walkin();
		
		if(a.getPrec().x>540&&a.getPrec().x<700&&
		   a.getPrec().y<=0)
		{
			a.getPrec().x = 540;
			a.getPrec().y = 20;
			parent.setTotaltime(totaltime);
			game.setScreen(parent);
			//dispose();
		}
		
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
		r1 = null;
	}

}
