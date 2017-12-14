package cn.edu.hdu.tankbattle.bullet;

import java.awt.Graphics;

import javax.swing.JPanel;

import cn.edu.hdu.tankbattle.model.IDrawable;
import cn.edu.hdu.tankbattle.model.TankGameImages;
import cn.edu.hdu.tankbattle.view.GamePanel;

/**
 * 子弹类，实现Runnable接口
 * 
 * @author 1052067939
 * @version 1.0
 * @since JavaSe-1.6
 *
 */
public class Bullet implements Runnable, IDrawable {
	private int speed;
	private int x;
	private int y;
	
	// 子彈是不是正在飛，意味存在於遊戲場景
	private boolean isFlying;
	// 游戏暂停时存储子弹速度
	private int speedVector;
	
	private IBulletFly flyPolicy;
	
	public Bullet(int x, int y, IBulletFly flyPolicy) {
		this.setX(x);
		this.setY(y);
		this.flyPolicy = flyPolicy;
		this.setSpeed(4);
		this.setFlying(true);
		Thread threadBullet = new Thread(this); // 创建子弹线程
		threadBullet.start();
	}

	@Override
	public void run() {
		while (true) {
			this.flyPolicy.bulletFly(this);
			
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
	
	public void draw(Graphics g, JPanel panel) {
		g.drawImage(TankGameImages.bullet, getX() - 2, getY() - 2, 4, 4, panel);
	}
}