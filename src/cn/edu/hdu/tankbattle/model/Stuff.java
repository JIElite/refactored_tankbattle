package cn.edu.hdu.tankbattle.model;

import java.awt.Color;

/**
 * 东西类，简单的一个对象
 * <p>
 * 
 * @author 1052067939
 * @version 1.0
 * @since JavaSe-1.6
 */
public class Stuff {
	/**
	 * x坐标
	 */
	private int x;
	/**
	 * y坐标
	 */
	private int y;
	/**
	 * 宽度
	 */
	private int width;
	/**
	 * 长度
	 */
	private int height;
	/**
	 * 东西第一个类型属性
	 */
	private int type;
	/**
	 * 东西第二个类型属性
	 */
//	private int type2;
	/**
	 * 是否活着
	 */
	private boolean isLive = true;
	/**
	 * 颜色
	 */
	private Color color;
	/**
	 * 血量
	 */
	private int blood;

	/**
	 * 东西类构造方法
	 * 
	 * @param x
	 *            事物对象的x坐标
	 * @param y
	 *            事物对象的y坐标
	 */
	public Stuff(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getType() {
		return type;
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


	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

//	public int getType2() {
//		return type2;
//	}
//
//	public void setType2(int type2) {
//		this.type2 = type2;
//	}

	public void setBlood(int blood) {
		this.blood = blood;
	}

	public int getBlood() {
		return blood;
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
}
