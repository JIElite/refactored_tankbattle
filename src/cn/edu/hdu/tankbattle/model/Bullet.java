package cn.edu.hdu.tankbattle.model;

import cn.edu.hdu.tankbattle.constant.Direction;
import cn.edu.hdu.tankbattle.view.GamePanel;

/**
 * 子弹类，实现Runnable接口
 * 
 * @author 1052067939
 * @version 1.0
 * @since JavaSe-1.6
 *
 */
public class Bullet implements Runnable {
	private int speed;
	private int x;
	private int y;
	private int direct;
	/**
	 * 子弹是否存活
	 */
	private boolean isFlying;
	/**
	 * 游戏暂停时存储子弹速度
	 */
	private int speedVector;

	/**
	 * 子弹类构造方法
	 * 
	 * @param x
	 *            子弹x坐标
	 * @param y
	 *            子弹y坐标
	 * @param direct
	 *            子弹的方向
	 */
	public Bullet(int x, int y, int direct) {
		this.setX(x);
		this.setY(y);
		this.setDirect(direct);
		this.setSpeed(4);
		this.setFlying(true);
		Thread threadBullet = new Thread(this); // 创建子弹线程
		threadBullet.start();
	}

	@Override
	public void run() {
		this.bulletFly(); // 子弹开始移动
	}

	/**
	 * 子弹向前移动
	 */
	public void bulletFly() {
		while (true) {
			switch (direct) { // 选择子弹的方向
			case Direction.NORTH:
				this.setY(this.getY() - this.getSpeed());
				break;
			case Direction.SOUTH:
				this.setY(this.getY() + this.getSpeed());
				break;
			case Direction.WEST:
				this.setX(this.getX() - this.getSpeed());
				break;
			case Direction.EAST:
				this.setX(this.getX() + this.getSpeed());
				break;
			}
			if (x < 5 || x > GamePanel.WIDTH - 5 || y < 5
					|| y > GamePanel.HEIGHT - 5) { // 判断子弹是否碰到边界
				this.isFlying = false; // 子弹死亡
				break;
			}
			try {
				Thread.sleep(36); // 每隔25毫秒移动一次
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
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

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getDirect() {
		return direct;
	}

	public void setDirect(int direct) {
		this.direct = direct;
	}

	public boolean isFlying() {
		return this.isFlying;
	}

	public void setFlying(boolean isFlying) {
		this.isFlying = isFlying;
	}

	public void setSpeedVector(int speedVector) {
		this.speedVector = speedVector;
	}

	public int getSpeedVector() {
		return speedVector;
	}
}