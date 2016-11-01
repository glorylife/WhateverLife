package com.hello;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class NPC extends Person{
	 private String name;
	 private Texture picture;
	 private Rectangle prec;
	 public NPC(String n,String p,String p2,String p3,String p4,int width,int height,int x,int y)
	 {
		 super(n,p,p2, p3, p4, width,height, x, y);
	 }

}
