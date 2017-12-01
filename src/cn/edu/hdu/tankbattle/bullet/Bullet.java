package cn.edu.hdu.tankbattle.bullet;

import cn.edu.hdu.tankbattle.view.GamePanel;

/**
 * 子弹类，实现Runnable接口
 * 
 * @author 1052067939
 * @version 1.0
 * @since JavaSe-1.6
 *
 */
public abstract class Bullet implements Runnable {
	private int speed;
	private int x;
	private int y;
	
	// 子彈是不是正在飛，意味存在於遊戲場景
	private boolean isFlying;
	// 游戏暂停时存储子弹速度
	private int speedVector;

	public Bullet(int x, int y) {
		this.setX(x);
		this.setY(y);
		this.setSpeed(4);
		this.setFlying(true);
		Thread threadBullet = new Thread(this); // 创建子弹线程
		threadBullet.start();
	}

	@Override
	public void run() {
		while (true) {
			this.bulletFly();
			
			// 子彈邊界檢測，看看是不是超出遊戲範圍，如果超出遊戲範圍便移除子彈。
			if (x < 5 || x > GamePanel.WIDTH - 5 || y < 5
					|| y > GamePanel.HEIGHT - 5) {
				this.isFlying = false;
				break;
			}
			try {
				Thread.sleep(36); // 每隔25毫秒移动一次
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 子弹向前移动
	 */
	public abstract void bulletFly();
	
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