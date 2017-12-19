package cn.edu.hdu.tankbattle.model;

import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * 水对象，继承自东西类
 * 
 * @author 1052067939
 * @version 1.0
 * @since JavaSe-1.6
 */
public class Water extends Stuff {
	
	public Water(Position p) {
		super(p);
		setType(Stuff.WATER);
		setWidth(20);
		setHeight(20);
	}
	
	public void draw(Graphics g, JPanel panel) {
		g.drawImage(TankGameImages.stuffImg[getType()],
				getX() - 10, getY() - 10, 20, 20, panel);
	}
}
