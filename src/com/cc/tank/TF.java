package com.cc.tank;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TF {

	public static void main(String[] args) throws InterruptedException {
		TankFrame tf=new TankFrame();
		
		while(true) {
			Thread.sleep(50);
			tf.repaint();
		}
		
		
		
		

	}

}
