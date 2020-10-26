package com.cc.tank;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame{
	
	int x=200;
	int y=200;
	Dir dir=Dir.DOWN;
	private static final int speed=10;
	
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
	
	@Override
	public void paint(Graphics g){//只要窗口需要重新绘制就被自动调用，会清理之前的显示
		g.fillRect(x, y, 50, 50);//填充矩形
		//x+=10;
		//y+=10;
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
			
			setMainTankDir();
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

			default:
				break;
			}
			
			setMainTankDir();
		}

		private void setMainTankDir() {
			if(bL) dir=Dir.LEFT;
			if(bR) dir=Dir.RIGHT;
			if(bU) dir=Dir.UP;
			if(bD) dir=Dir.DOWN;
			
		}
		
	}
	

}
