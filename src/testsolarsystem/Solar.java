package testsolarsystem;

import java.awt.Graphics;
import java.awt.Image;

import cn.jiansuyan.game1.GameUtil;
import util.MyFrame;

/*
 * 太阳系的主窗口
 */

public class Solar extends MyFrame{
	Image bg = GameUtil.getImage("images/solar-bg.jpg");
	Stars sun = new Stars("images/sun.jpg",300,300);
	
	public void paint(Graphics g){
		g.drawImage(bg,0,0,null);
	}
	
	public static void main(String[] args){
		new Solar().launchFrame();
	}
}
