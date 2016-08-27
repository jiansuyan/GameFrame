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
public class GameFrame5 extends MyFrame { //GUI:AWT, swing
	
	Image img = GameUtil.getImage("images/test.jpg");
	
	private double  x=100, y=100;
	private boolean left;
	private double degree = 3.14/3; //[0,2pi], »¡¶È
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
	
	public static void main(String[] args){
		GameFrame5 gf = new GameFrame5();
		gf.launchFrame();
	}
}
