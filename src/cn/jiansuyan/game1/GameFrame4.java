package cn.jiansuyan.game1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * The game frame class,
 * test the frame moving with all kind of 
 * 
 * @author test
 *
 */
public class GameFrame4 extends Frame { //GUI:AWT, swing
	
	Image img = GameUtil.getImage("images/test.jpg");
	
	
	
	// Loading frame 
	
	public void launchFrame(){
		setSize(500,500);
		setLocation(100,100);
		setVisible(true);
		new PaintThread().start(); //启动线程
		
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
	}
	
	private double  x=100, y=100;
	private boolean left;
	private double degree = 3.14/3; //[0,2pi], 弧度
	@Override
	public void paint(Graphics g) {
		g.drawImage(img, (int)x, (int)y, null);
	x += 30*Math.cos(degree);
		y += 30*Math.sin(degree);
		
		if(y> 500-30){
			degree = -degree;
		}
		if(y < 30){
			degree = -degree;
		}
		if(x < 0){
			degree = Math.PI - degree;
		}
		if(x >500 -30){
			degree = Math.PI - degree;
		}  
		
		
	/*	if(left){
			x -= 3;
		}else{
			x += 3;
		}
		if(x > 500){
			left = true;
		}
		if(x < 0){
			left = false;
		}
		*/
		
	
		
	}
	/**
	 * 定义一个重画窗口的线程类，是一个内部类
	 * @author test
	 *
	 */
	class PaintThread extends Thread{
		public void run(){
			while(true){
				repaint();
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 
			}
		}
	}
	
	public static void main(String[] args){
		GameFrame4 gf = new GameFrame4();
		gf.launchFrame();
	}
}
