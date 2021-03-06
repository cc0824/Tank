package com.cc.tank;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet {
	private static final int SPEED=5;
	private static final int WIDTH=16,HEIGHT=16;
	
	private Dir dir;
	private int x,y;
	
	
	
	public Bullet(int x, int y,Dir dir) {
		super();
		this.dir = dir;
		this.x = x;
		this.y = y;
	}
	
	public void paint(Graphics g) {
		Color c=g.getColor();
		g.setColor(Color.RED);
		g.fillOval(x, y, WIDTH, HEIGHT);//填充圆形
		g.setColor(c);
		move();
		
	}
	
	private void move() {
		switch (dir) {
		case LEFT:
			x-=SPEED;
			break;
		case RIGHT:
			x+=SPEED;
			break;
		case UP:
			y-=SPEED;
			break;
		case DOWN:
			y+=SPEED;
			break;
		default:
			break;
		}
		
	}
	
	public Dir getDir() {
		return dir;
	}
	public void setDir(Dir dir) {
		this.dir = dir;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	
	

}
