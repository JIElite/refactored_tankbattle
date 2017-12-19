package cn.edu.hdu.tankbattle.model;

import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * 爆炸对象，是一个正方形
 * 
 * @author 1052067939
 * @version 1.0
 * @since JavaSe-1.6
 */
public class Bomb implements IDrawable {
	/**
	 * 炸弹的宽度
	 */
	private int l;
	/**
	 * 炸弹的x坐标
	 */
	private int x;
	/**
	 * 炸弹的y坐标
	 */
	private int y;
	/**
	 * 炸弹的動畫持續時間
	 */
	private int lifeTime = 10;
	/**
	 * 炸弹是否活着
	 */
	boolean isLive = true;

	/**
	 * 炸弹的构造函数
	 * 
	 * @param x
	 *            炸弹的x坐标
	 * @param y
	 *            炸弹的y坐标
	 */
	public Bomb(int x, int y) { // 构造函数，初始化工作
		this.x = x;
		this.y = y;
	}

	public void lifeDown() {
		if (lifeTime > 0) {
			lifeTime--;
		}
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

	public int getLifeTime() {
		return lifeTime;
	}

	public void setLifeTime(int lifeTime) {
		this.lifeTime = lifeTime;
	}

	public boolean isLive() {
		return isLive;
	}

	public void setLive(boolean isLive) {
		this.isLive = isLive;
	}

	public int getL() {
		return l;
	}

	public void setL(int l) {
		this.l = l;
	}
	
	public void draw(Graphics g, JPanel panel) {
		int bomb_image_index = 0;
		if (getLifeTime() > 24) { // 生命值21-25
			bomb_image_index = 0;
		} else if (getLifeTime() > 18) { // 生命值16-20
			bomb_image_index = 1;
		} else if (getLifeTime() > 12) { // 生命值11-15
			bomb_image_index = 2;
		} else if (getLifeTime() > 6) { // 生命值6-10
			bomb_image_index = 3;
		} else { // 生命值低于6
			bomb_image_index = 4;
		}
		g.drawImage(TankGameImages.bomb[bomb_image_index], getX() - l / 2, getY()
				- l / 2, l, l, panel);
	}
}
