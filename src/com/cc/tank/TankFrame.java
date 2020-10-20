package com.cc.tank;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame {

	public static void main(String[] args) {
		Frame f=new Frame();
		f.setSize(800, 600);//大小
		f.setResizable(false);//大小不可变
		f.setTitle("tank war");//标题
		f.setVisible(true);//打开窗口
		
		f.addWindowListener(new WindowAdapter() {//监听器点击x关闭窗口
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		

	}

}
