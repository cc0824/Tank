package com.cc.tank;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame{
	
	int x=200;
	int y=200;
	
	public TankFrame() {
		setSize(800, 600);//大小
		setResizable(false);//大小不可变
		setTitle("tank war");//标题
		setVisible(true);//打开窗口
		
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
		x+=10;
		y+=10;
		
	}
	

}
