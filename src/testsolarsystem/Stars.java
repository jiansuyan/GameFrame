package testsolarsystem;

import java.awt.Graphics;
import java.awt.Image;

import cn.jiansuyan.game1.GameUtil;

public class Stars {
	Image img;
	double x,y;
	
	public void draw(Graphics g){
		g.drawImage(img,(int)x, (int)y, null);
	}
	
	
	public Stars(String imgpath, double x, double y){
		this.img = GameUtil.getImage(imgpath);
		this.x = x;
		this.y = y;
	}
}
