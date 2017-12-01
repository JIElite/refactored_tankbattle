package cn.edu.hdu.tankbattle.model;

import java.util.Vector;

import cn.edu.hdu.tankbattle.bullet.Bullet;
import cn.edu.hdu.tankbattle.bullet.BulletFactory;
import cn.edu.hdu.tankbattle.constant.Direction;
import cn.edu.hdu.tankbattle.constant.StuffType;
import cn.edu.hdu.tankbattle.view.GamePanel;

/**
 * 坦克类，继承自东西类
 * 
 * @author 1052067939
 * @version 1.0
 * @since JavaSe-1.6
 */
public class Tank extends Stuff{
	/**
	 * 我的坦克
	 */
	public static final int MY = 0;
	/**
	 * 敌人坦克
	 */
	public static final int ENEMY = 1;

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

	private int direct;
	
	private BulletFactory bulletfactory;
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
	public Tank(int x, int y, int direct) {
		super(x, y);
		this.setDirect(direct);
		this.bullets = new Vector<Bullet>();
		this.setType(StuffType.TANK);
		bulletfactory = new BulletFactory();
	}

	public int getDirect() {
		return direct;
	}

	public void setDirect(int direct) {
		this.direct = direct;
	}
	
	/**
	 * 射击，发射一颗子弹
	 * 
	 * @param tank
	 *            坦克对象，注意，是自己，不是敌人，呵呵
	 */
	public void shot(Tank tank) {
		Bullet bullet = bulletfactory.makeBullet(tank);
		this.getBullets().add(bullet);
		Thread t = new Thread(bullet);
		t.start();
	}

	/**
	 * 坦克往北走
	 */
	public void goNorth() {
		this.setDirect(Direction.NORTH);
		if (this.getY() > 20) {
			this.setY(this.getY() - this.speed);
		} else {
			this.setFrontInfomation(StuffType.IRON);
		}
	}

	/**
	 * 坦克往南走
	 */
	public void goSouth() {
		this.setDirect(Direction.SOUTH);
		if (this.getY() < GamePanel.HEIGHT - 20) {
			this.setY(this.getY() + this.speed);
		} else {
			this.setFrontInfomation(StuffType.IRON); // 碰到边界就相当于碰到铁块
		}
	}

	/**
	 * 坦克往西走
	 */
	public void goWest() {
		this.setDirect(Direction.WEST);
		if (this.getX() > 20 && this.getY() <= GamePanel.HEIGHT - 20) {
			this.setX(this.getX() - this.speed);
		} else {
			this.setFrontInfomation(StuffType.IRON);
		}
	}

	/**
	 * 坦克往东走
	 */
	public void goEast() {
		this.setDirect(Direction.EAST);
		if (this.getX() < GamePanel.WIDTH - 20
				&& this.getY() <= GamePanel.HEIGHT - 20) {
			this.setX(this.getX() + this.speed);
		} else {
			this.setFrontInfomation(StuffType.IRON);
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
			this.goNorth();
		case Direction.SOUTH:
			this.goSouth();
		case Direction.WEST:
			this.goWest();
		case Direction.EAST:
			this.goEast();
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
		if (this.getDirect() == Direction.NORTH) {
			this.setY(this.getY() - this.getSpeed()); // 先假设该坦克往前移动一步
			if (Math.abs(this.getY() - y) < length
					&& Math.abs(this.getX() - x) < length) { // 如果在远离，此时他想逃出重叠，所以就设b为false，让它能够动
				b = true;
				this.setY(this.getY() + this.getSpeed());
			} else {
				this.setY(this.getY() + this.getSpeed());
			}
		}
		if (this.getDirect() == Direction.SOUTH) {
			this.setY(this.getY() + this.getSpeed()); // 先假设该坦克往前移动一步
			if (Math.abs(this.getY() - y) < length
					&& Math.abs(this.getX() - x) < length) {
				b = true;
			}
			this.setY(this.getY() - this.getSpeed());
		}
		if (this.getDirect() == Direction.EAST) {
			this.setX(this.getX() + this.getSpeed());
			if (Math.abs(this.getY() - y) < length
					&& Math.abs(this.getX() - x) < length) {
				b = true;
			}
			this.setX(this.getX() - this.getSpeed());
		}
		if (this.getDirect() == Direction.WEST) {
			this.setX(this.getX() - this.getSpeed());
			if (Math.abs(this.getY() - y) < length
					&& Math.abs(this.getX() - x) < length) {
				b = true;
			}
			this.setX(this.getX() + this.getSpeed());
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
