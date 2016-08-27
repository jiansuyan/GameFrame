package cn.jiansuyan.game1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * The game frame class
 * @author test
 *
 */


public class GameFrame extends Frame { //GUI:AWT, swing
	
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
	@Override
	public void paint(Graphics g) {
		System.out.println("paint");
		g.drawLine(100,100,200,200);
		g.drawRect(100, 100, 200, 200);
		g.drawOval(100, 100, 200, 200);
		Font f = new Font("Arial",Font.BOLD,100);
		g.setFont(f);
		g.drawString("jiansuyan", 200, 200);
		
		g.fillRect(100, 100, 20, 20);
		
		Color c = g.getColor();
		g.setColor(Color.red);
		g.fillOval(300, 300, 20, 20);
		g.setColor(c);
		
		g.drawImage(img, (int)x, (int)y, null);
		x += 3;
		y += 3;
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
		GameFrame gf = new GameFrame();
		gf.launchFrame();
	}
}