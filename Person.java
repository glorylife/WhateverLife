package com.hello;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Person {
	
	 private String name;
	 private Texture[] picture;
	 private Rectangle prec;
	 private Building[] building;
	 private NPC[] npc;
	 
	 public NPC[] getNpc() {
		return npc;
	}

	public void setNpc(NPC[] npc) {
		this.npc = npc;
	}

	
	 
	 
	 public Texture[] getPicture() {
		return picture;
	}

	public void setPicture(Texture[] picture) {
		this.picture = picture;
	}

	public Rectangle getPrec() {
		return prec;
	}

	public void setPrec(Rectangle prec) {
		this.prec = prec;
	}

	
	 
	 public Person(String n,String p,String p2,String p3,String p4,int width,int height,int x,int y){
		 picture = new Texture[5];
		 picture[0] = new Texture(p);
		 picture[1] = new Texture(p2);
		 picture[2] = new Texture(p3);
		 picture[3] = new Texture(p4);
		 
		 picture[4] = new Texture(p);
		 
		 prec = new Rectangle();
		 prec.width = width;
		 prec.height = height;
		 prec.x = x;
		 prec.y = y;
		 
		 name = n;
		 
	 }
	 
	 public void walk()
	 {
		
		
		if(Gdx.input.isKeyPressed(Keys.UP)) 
		{
			picture[4] = picture[1];
			
			for(int i = 0;i<building.length;i++)
			{
				building[i].getPrec().y -= 200*Gdx.graphics.getDeltaTime();
			}
			
		}
		if(Gdx.input.isKeyPressed(Keys.DOWN)&&!overlap4()) 
		{
			picture[4] = picture[0];
			for(int i = 0;i<building.length;i++)
			{
				building[i].getPrec().y += 200*Gdx.graphics.getDeltaTime();
			}
		}
		if(Gdx.input.isKeyPressed(Keys.RIGHT)&&!overlap()) 
		{
			picture[4] = picture[2];
			for(int i = 0;i<building.length;i++)
			{
				building[i].getPrec().x -= 200*Gdx.graphics.getDeltaTime();
			}
			
		}
		if(Gdx.input.isKeyPressed(Keys.LEFT)&&!overlap3()) 
		{
			picture[4] = picture[3];
			for(int i = 0;i<building.length;i++)
			{
				building[i].getPrec().x += 200*Gdx.graphics.getDeltaTime();
			}
		}
	 }
	 
	 public void walkin()
	 {
		
		
		if(Gdx.input.isKeyPressed(Keys.UP)&&prec.y<=720-prec.height) 
		{
			prec.y += 200*Gdx.graphics.getDeltaTime();
		}
		if(Gdx.input.isKeyPressed(Keys.DOWN)&&prec.y>=0) 
		{
			prec.y -= 200*Gdx.graphics.getDeltaTime();
		}
		if(Gdx.input.isKeyPressed(Keys.RIGHT)&&prec.x<=1280-prec.width) 
		{
			prec.x += 200*Gdx.graphics.getDeltaTime();
		}
		if(Gdx.input.isKeyPressed(Keys.LEFT)&&prec.x>=0) 
		{
			prec.x -= 200*Gdx.graphics.getDeltaTime();
		}
	 }

	public void setBuilding(Building[] a) {
		this.building = a;
		
	}
	
	public boolean overlap()
	{
		for(int i = 0;i<building.length;i++)
		{
			if(prec.x+prec.width+5>=building[i].getPrec().x&&
					   prec.y+prec.height>building[i].getPrec().y&&
					   prec.y<=building[i].getPrec().y+building[i].getPrec().height
					   &&prec.x<=building[i].getPrec().x)
			{
				//prec.x--;
				return true;			
			}
				
		}
		
		for(int i = 0;i<npc.length;i++)
		{
			if(prec.x+prec.width+5>=npc[i].getPrec().x&&
					   prec.y+prec.height>npc[i].getPrec().y&&
					   prec.y<=npc[i].getPrec().y+npc[i].getPrec().height
					   &&prec.x<=npc[i].getPrec().x)
			{
				//prec.x--;
				return true;			
			}
				
		}
		return false;
		
			
	}
	
	public boolean overlap2()
	{
		for(int i = 0 ; i<building.length;i++)
		{
			if(prec.x+prec.width>=building[i].getPrec().x&&
					prec.y+prec.height+5>=building[i].getPrec().y&&
					prec.x<=building[i].getPrec().x+building[i].getPrec().width&&
					prec.y<building[i].getPrec().y)
				{
					//prec.y--;
					return true;
				}
				
		}
		
		for(int i = 0 ; i<npc.length;i++)
		{
			if(prec.x+prec.width>=npc[i].getPrec().x&&
					prec.y+prec.height+5>=npc[i].getPrec().y&&
					prec.x<=building[i].getPrec().x+npc[i].getPrec().width&&
					prec.y<npc[i].getPrec().y)
				{
					//prec.y--;
					return true;
				}
				
		}
		return false;
	}
	
	public boolean overlap3()
	{
		for(int i = 0;i<building.length;i++)
		{
			if(prec.x<=building[i].getPrec().x+building[i].getPrec().width+5&&
					building[i].getPrec().x<prec.x+prec.width&&
					   (prec.y>=building[i].getPrec().y||
					   prec.y+prec.height>building[i].getPrec().y)&&
					   prec.y<building[i].getPrec().y+building[i].getPrec().height)
					{
						//prec.x++;
						return true;
					}
				
		}
		
		for(int i = 0;i<npc.length;i++)
		{
			if(prec.x<=npc[i].getPrec().x+npc[i].getPrec().width+5&&
					npc[i].getPrec().x<prec.x+prec.width&&
					   (prec.y>=npc[i].getPrec().y||
					   prec.y+prec.height>npc[i].getPrec().y)&&
					   prec.y<npc[i].getPrec().y+npc[i].getPrec().height)
					{
						//prec.x++;
						return true;
					}
				
		}
		return false;
		
	}
	
	public boolean overlap4()
	{
		for(int i = 0;i<building.length;i++)
		{
			if(prec.x+prec.width>=building[i].getPrec().x&&
					   prec.x<=building[i].getPrec().x+building[i].getPrec().width&&
					   prec.y<building[i].getPrec().y+building[i].getPrec().height+5&&
					   building[i].getPrec().y<prec.y+prec.width)
					{
						return true;
					}
				
		}
		
		for(int i = 0;i<npc.length;i++)
		{
			if(prec.x+prec.width>=npc[i].getPrec().x&&
					   prec.x<=npc[i].getPrec().x+npc[i].getPrec().width&&
					   prec.y<npc[i].getPrec().y+npc[i].getPrec().height+5&&
					   npc[i].getPrec().y<prec.y+prec.width)
					{
						return true;
					}
				
		}
		return false;
		
	}
	
	public boolean respond()
	{
		if(Gdx.input.isKeyJustPressed(Keys.SPACE)&&
			prec.x+prec.width+5>=npc[0].getPrec().x)
		{
			System.out.println("a");
			return true;
		}
		return false;
	}
	public void show(Hello game)
	{
		game.batch.draw(picture[4], prec.x, prec.y);
	}
	public void enterBuilding(Hello game,RoomScreen room1,float totaltime)
	{
		for(int i = 0;i<building.length;i++)
		{
			if(prec.overlaps(building[i].getPrec()))
			{
				prec.y-=5;
				System.out.println("enter to b"+i);
				room1.setTotaltime(totaltime);
				game.setScreen(room1);
				
				//dispose();
			}
		}
	}
}
