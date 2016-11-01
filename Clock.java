package com.hello;

import com.badlogic.gdx.Screen;

public class Clock implements Runnable{
	
	private int seconds;
	private int minutes;
	private int hours;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0;i<10;i++)
		{
			if(i+1>=10)
			{
				i = 0;
			}
			seconds++;
			try{
				Thread.sleep(1000);
			}
			catch(InterruptedException ex)
			{
				ex.printStackTrace();
			}
		}
	}
	public int getSeconds() {
		return seconds;
	}
	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
	

}
