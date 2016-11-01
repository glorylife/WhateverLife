package com.hello;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Room {
	private Texture picture;
	private Rectangle prec;
	private String name;
	
	public Room(String s,String n,int width,int height)
	{
		name = s;
		picture = new Texture(n);
		prec = new Rectangle();
		prec.width = width;
		prec.height = height;
		prec.x = prec.y = 0;
	}

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
}
