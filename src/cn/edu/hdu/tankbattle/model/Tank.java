package cn.edu.hdu.tankbattle.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Vector;

import javax.swing.JPanel;

import cn.edu.hdu.tankbattle.constant.Direction;
import cn.edu.hdu.tankbattle.model.bullet.Bullet;
import cn.edu.hdu.tankbattle.model.bullet.BulletMaker;
import cn.edu.hdu.tankbattle.view.GamePanel;

/**
 * 坦克类，继承自东西类
 * 
 * @author 1052067939
 * @version 1.0
 * @since JavaSe-1.6
 */
public abstract class Tank extends Stuff {
	/**
	 * 坦克的移动速度
	 */
	private int speed = 4; // 坦克移动速度
	/**
	 * 挡住坦克前面的东西
	 */
	private int frontInfomation = -1;
	/**
	 * 坦克的子弹容量
	 */
	private Vector<Bullet> bullets;
	/**
	 * 坦克是否重叠属性,前面的障碍物不可过去
	 */
	private boolean isOverlapNo = false;
	/**
	 * 坦克是否重叠，前面的障碍物可以过去，用子弹可以打掉
	 */
	private boolean isOverlapYes = false;
	/**
	 * 游戏暂停时存储速度
	 */
	private int speedVector;

	private int HealthPoint;
	
	protected Color hp_color = Color.black;
	
	private int direct;
	
	private BulletMaker bulletfactory;
	/**
	 * 坦克的构造方法
	 * 
	 * @param x
	 *            坦克的x坐标
	 * @param y
	 *            坦克的y坐标
	 * @param direct
	 *            坦克的方向
	 */
	public Tank(Position p, int direct) {
		super(p);
		setDirect(direct);
		bullets = new Vector<Bullet>();
		setType(Stuff.TANK);
		bulletfactory = new BulletMaker();
	}
	
	public abstract Image getImage();
	
	public void draw(Graphics g, JPanel panel) {
		// draw HP bar
		g.setColor(hp_color);
		g.fillRect(getX() - 20, getY() - 30, getHealthPoint() * 4, 5);
		// draw Tank Image
		g.drawImage(getImage(), getX() - 20, getY() - 20, 40, 40, panel);
	}
	
	public void setDirect(int direct) {
		this.direct = direct;
	}
	
	public int getDirect() {
		return direct;
	}
	
	public void setHealthPoint(int hp) {
		this.HealthPoint = hp;
	}
	
	public int getHealthPoint() {
		return this.HealthPoint;
	}
	
	public int getMuzzleX() {
		int offset = 0;
		switch(getDirect()) {
			case Direction.EAST:
				offset = 20;
				break;
			case Direction.WEST:
				offset = -20;
				break;
			default:
				break;
		}
		return this.getX() + offset;
	}
	
	public int getMuzzleY() {
		int offset = 0;
		switch(getDirect()) {
		case Direction.NORTH:
			offset = -20;
			break;
		case Direction.SOUTH:
			offset = 20;
			break;
		default:
			break;
		}
		return getY() + offset;
	}
	
	public void shot() {
		Bullet bullet = bulletfactory.makeBullet(this);
		getBullets().add(bullet);
		Thread t = new Thread(bullet);
		t.start();
	}

	/**
	 * 坦克往北走
	 */
	public void goNorth() {
		setDirect(Direction.NORTH);
		if (getY() > 20) {
			setY(getY() - speed);
		} else {
			setFrontInfomation(Stuff.IRON);
		}
	}

	/**
	 * 坦克往南走
	 */
	public void goSouth() {
		setDirect(Direction.SOUTH);
		if (getY() < GamePanel.HEIGHT - 20) {
			setY(getY() + speed);
		} else {
			setFrontInfomation(Stuff.IRON); // 碰到边界就相当于碰到铁块
		}
	}

	/**
	 * 坦克往西走
	 */
	public void goWest() {
		setDirect(Direction.WEST);
		if (getX() > 20 && getY() <= GamePanel.HEIGHT - 20) {
			setX(getX() - speed);
		} else {
			setFrontInfomation(Stuff.IRON);
		}
	}

	/**
	 * 坦克往东走
	 */
	public void goEast() {
		setDirect(Direction.EAST);
		if (getX() < GamePanel.WIDTH - 20
				&& getY() <= GamePanel.HEIGHT - 20) {
			setX(getX() + speed);
		} else {
			setFrontInfomation(Stuff.IRON);
		}
	}

	/**
	 * 坦克往指定的方向走
	 * 
	 * @param where
	 *            方向
	 */

	public void go(int direction) {
		switch (direction) {
		case Direction.NORTH:
			goNorth();
		case Direction.SOUTH:
			goSouth();
		case Direction.WEST:
			goWest();
		case Direction.EAST:
			goEast();
		}
	}

	/**
	 * 判断坦克是否与另一个事物重叠
	 * 
	 * @param stuff
	 *            东西对象
	 * @param length
	 *            两者之间的最短距离
	 * @return 是否重叠
	 */
	public boolean Overlap(Stuff stuff, int length) {
		boolean b = false;
		int x = stuff.getX();
		int y = stuff.getY();
		if (getDirect() == Direction.NORTH) {
			setY(getY() - getSpeed()); // 先假设该坦克往前移动一步
			if (Math.abs(getY() - y) < length
					&& Math.abs(getX() - x) < length) { // 如果在远离，此时他想逃出重叠，所以就设b为false，让它能够动
				b = true;
				setY(getY() + getSpeed());
			} else {
				setY(getY() + getSpeed());
			}
		}
		if (getDirect() == Direction.SOUTH) {
			setY(getY() + getSpeed()); // 先假设该坦克往前移动一步
			if (Math.abs(getY() - y) < length
					&& Math.abs(getX() - x) < length) {
				b = true;
			}
			setY(getY() - getSpeed());
		}
		if (getDirect() == Direction.EAST) {
			setX(getX() + getSpeed());
			if (Math.abs(getY() - y) < length
					&& Math.abs(getX() - x) < length) {
				b = true;
			}
			setX(getX() - getSpeed());
		}
		if (getDirect() == Direction.WEST) {
			setX(getX() - getSpeed());
			if (Math.abs(getY() - y) < length
					&& Math.abs(getX() - x) < length) {
				b = true;
			}
			setX(getX() + getSpeed());
		}
		return b;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public Vector<Bullet> getBullets() {
		return bullets;
	}

	public void setBullets(Vector<Bullet> bullets) {
		this.bullets = bullets;
	}

	public void setSpeedVector(int speedVector) {
		this.speedVector = speedVector;
	}

	public int getSpeedVector() {
		return speedVector;
	}

	public boolean isOverlapNo() {
		return isOverlapNo;
	}

	public void setOverlapNo(boolean isOverlapNo) {
		this.isOverlapNo = isOverlapNo;
	}

	public boolean isOverlapYes() {
		return isOverlapYes;
	}

	public void setOverlapYes(boolean isOverlapYes) {
		this.isOverlapYes = isOverlapYes;
	}

	public int getFrontInfomation() {
		return frontInfomation;
	}

	public void setFrontInfomation(int frontInfomation) {
		this.frontInfomation = frontInfomation;
	}
	
}
