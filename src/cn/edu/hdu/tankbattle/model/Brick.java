package cn.edu.hdu.tankbattle.model;

import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * 砖块类，由东西类继承而来
 * 
 * @author 1052067939
 * @version 1.0
 * @since Java-1.6
 *
 */
public class Brick extends Stuff {
	public Brick(Position p) {
		super(p);
		setType(Stuff.BRICK);
		setWidth(20);
		setHeight(20);
	}
	
	public void draw(Graphics g, JPanel panel) {
		g.drawImage(TankGameImages.stuffImg[getType()],
				getX() - 10, getY() - 10, 20, 20, panel);
	}
}
