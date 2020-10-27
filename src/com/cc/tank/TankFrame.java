package com.cc.tank;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame{
	
	Tank tank=new Tank(200,200,Dir.DOWN,this);//传递窗口的引用
	Bullet b=new Bullet(300,300,Dir.DOWN);
	private static final int GAME_WIDTH=800,GAME_HEIGHT=600;
	
	
	public TankFrame() {
		setSize(800, 600);//大小
		setResizable(false);//大小不可变
		setTitle("tank war");//标题
		setVisible(true);//打开窗口
		
		this.addKeyListener(new MyKeyListener());
		
		addWindowListener(new WindowAdapter() {//监听器点击x关闭窗口
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	//双缓冲消除闪烁
	Image offScreenImage = null;
	@Override
	public void update(Graphics g) {
		//在系统内存中把坦克图片画出来
		if (offScreenImage == null) {
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.BLACK);
		gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		//屏幕上画笔g将内存的图片画到屏幕上
		g.drawImage(offScreenImage, 0, 0, null);
	}
	
	@Override
	public void paint(Graphics g){//只要窗口需要重新绘制就被自动调用，会清理之前的显示
		tank.paint(g);//如果不这么写，需要tank.get(x)/get(y)获取，而x、y都是tank对象的属性，失去封装对象的意义
		b.paint(g);
	}
	
	class MyKeyListener extends KeyAdapter{
		
		boolean bU=false;//表示哪个方向键被按下
		boolean bD=false;
		boolean bL=false;
		boolean bR=false;

		@Override
		public void keyPressed(KeyEvent e) {//按下键盘
			int key=e.getKeyCode();
			switch (key) {
			case KeyEvent.VK_LEFT:
				//x-=10;
				bL=true;
				break;
			case KeyEvent.VK_RIGHT:
				//x+=10;
				bR=true;
				break;
			case KeyEvent.VK_UP:
				//y-=10;
				bU=true;
				break;
			case KeyEvent.VK_DOWN:
				//y+=10;
				bD=true;
				break;

			default:
				break;
			}
			
			setMainTankDir();//按键走
		}

		@Override
		public void keyReleased(KeyEvent e) {//释放键盘
			int key=e.getKeyCode();
			switch (key) {
			case KeyEvent.VK_LEFT:
				bL=false;
				break;
			case KeyEvent.VK_RIGHT:
				bR=false;
				break;
			case KeyEvent.VK_UP:
				bU=false;
				break;
			case KeyEvent.VK_DOWN:
				bD=false;
				break;
				
			case KeyEvent.VK_CONTROL://按下ctrl键开火
				tank.fire();
				break;

			default:
				break;
			}
			
			//不按键就停
			setMainTankDir();
		}

		private void setMainTankDir() {
			
			if(!bL && !bR && !bU && !bD) tank.setMoving(false);
			else {
				tank.setMoving(true);
				if(bL) tank.setDir(Dir.LEFT);
				if(bR) tank.setDir(Dir.RIGHT);
				if(bU) tank.setDir(Dir.UP);
				if(bD) tank.setDir(Dir.DOWN);
			}
			
			
		}
		
	}
	

}
