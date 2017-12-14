package cn.edu.hdu.tankbattle.model;

import java.awt.Graphics;
import java.util.Vector;

import javax.swing.JPanel;

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
public abstract class Tank extends Stuff implements IDrawable {
	/**
	 * 坦克的移动速度
	 */
	private int _speed = 4; // 坦克移动速度
	/**
	 * 挡住坦克前面的东西
	 */
	private int _frontInfomation = -1;
	/**
	 * 坦克的子弹容量
	 */
	private Vector<Bullet> _bullets;
	/**
	 * 坦克是否重叠属性,前面的障碍物不可过去
	 */
	private boolean _isOverlapNo = false;
	/**
	 * 坦克是否重叠，前面的障碍物可以过去，用子弹可以打掉
	 */
	private boolean _isOverlapYes = false;
	/**
	 * 游戏暂停时存储速度
	 */
	private int _speedVector;

	private int _HealthPoint;
	
	private int _direct;
	
	private BulletFactory _bulletfactory;
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
		this.setDirect(direct);
		this._bullets = new Vector<Bullet>();
		this.setType(StuffType.TANK);
		this._bulletfactory = new BulletFactory();
	}

	public int getDirect() {
		return this._direct;
	}

	public void setDirect(int direct) {
		this._direct = direct;
	}
	
	public void setHealthPoint(int hp) {
		this._HealthPoint = hp;
	}
	
	public int getHealthPoint() {
		return this._HealthPoint;
	}
	
	public int getMuzzleX() {
		int offset = 0;
		switch(this.getDirect()) {
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
		switch(this.getDirect()) {
		case Direction.NORTH:
			offset = -20;
			break;
		case Direction.SOUTH:
			offset = 20;
			break;
		default:
			break;
		}
		return this.getY() + offset;
	}
	
	public void shot() {
		Bullet bullet = this._bulletfactory.makeBullet(this);
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
			this.setY(this.getY() - this._speed);
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
			this.setY(this.getY() + this._speed);
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
			this.setX(this.getX() - this._speed);
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
			this.setX(this.getX() + this._speed);
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
		return this._speed;
	}

	public void setSpeed(int speed) {
		this._speed = speed;
	}

	public Vector<Bullet> getBullets() {
		return this._bullets;
	}

	public void setBullets(Vector<Bullet> bullets) {
		this._bullets = bullets;
	}

	public void setSpeedVector(int speedVector) {
		this._speedVector = speedVector;
	}

	public int getSpeedVector() {
		return this._speedVector;
	}

	public boolean isOverlapNo() {
		return this._isOverlapNo;
	}

	public void setOverlapNo(boolean isOverlapNo) {
		this._isOverlapNo = isOverlapNo;
	}

	public boolean isOverlapYes() {
		return this._isOverlapYes;
	}

	public void setOverlapYes(boolean isOverlapYes) {
		this._isOverlapYes = isOverlapYes;
	}

	public int getFrontInfomation() {
		return this._frontInfomation;
	}

	public void setFrontInfomation(int frontInfomation) {
		this._frontInfomation = frontInfomation;
	}
	
	public abstract void draw(Graphics g, JPanel panel);
}
