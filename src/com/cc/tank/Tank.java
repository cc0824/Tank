package com.cc.tank;

import java.awt.Color;
import java.awt.Graphics;

public class Tank {
	private int x,y;
	private Dir dir=Dir.DOWN;
	private static final int speed=5;
	private boolean moving = false;
	private TankFrame tf=null;
	
	public boolean isMoving() {
		return moving;
	}


	public void setMoving(boolean moving) {
		this.moving = moving;
	}


	public Tank(int x, int y, Dir dir,TankFrame tf) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf=tf;
	}
	

	public Dir getDir() {
		return dir;
	}


	public void setDir(Dir dir) {
		this.dir = dir;
	}


	public void paint(Graphics g) {
		Color c=g.getColor();
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, 50, 50);//填充矩形
		g.setColor(c);
		move();
		
	}


	private void move() {
		if(!moving) return;
		switch (dir) {
		case LEFT:
			x-=speed;
			break;
		case RIGHT:
			x+=speed;
			break;
		case UP:
			y-=speed;
			break;
		case DOWN:
			y+=speed;
			break;
		default:
			break;
		}
		
	}


	public void fire() {
		tf.b=new Bullet(this.x+17, this.y+17, this.dir);
		
	}
	
	

}
