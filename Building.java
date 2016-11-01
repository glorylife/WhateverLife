package com.hello;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Building {
	 private String name;
	 private Texture picture;
	 private Rectangle prec;
	 
	 public Texture getPicture() {
			return picture;
		}

		public void setPicture(Texture picture) {
			this.picture = picture;
		}

		public Rectangle getPrec() {
			return prec;
		}

		public void setPrec(Rectangle prec) {
			this.prec = prec;
		}

		
		 
		 public Building(String n,String p,int width,int height,int x,int y){
			 picture = new Texture(p);
			 
			 prec = new Rectangle();
			 prec.width = width;
			 prec.height = height;
			 prec.x = x;
			 prec.y = y;
			 
			 name = n;
		 }
		 
		 public void show(Hello game)
		{
			game.batch.draw(picture, prec.x, prec.y);
		}
}
