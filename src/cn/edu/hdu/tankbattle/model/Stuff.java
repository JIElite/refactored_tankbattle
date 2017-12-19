package cn.edu.hdu.tankbattle.model;

import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * 东西类，简单的一个对象
 * <p>
 * 
 * @author 1052067939
 * @version 1.0
 * @since JavaSe-1.6
 */
public abstract class Stuff implements IDrawable{
	public static final int BRICK = 0;
	public static final int IRON = 1;
	public static final int WATER = 2;
	public static final int TANK = 3;
	
	private Position position;
	private int width;
	private int height;
	private int type;
	private boolean isLive;

	public Stuff(Position p) {
		this.position = p;
		this.isLive = true;
	}

	public int getX() {
		return this.position.getX();
	}

	public void setX(int x) {
		this.position.setX(x);
	}

	public int getY() {
		return this.position.getY();
	}

	public void setY(int y) {
		this.position.setY(y);
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public boolean isLive() {
		return isLive;
	}

	public void setLive(boolean isLive) {
		this.isLive = isLive;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public abstract void draw(Graphics g, JPanel panel);
}
