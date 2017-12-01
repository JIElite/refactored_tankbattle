package cn.edu.hdu.tankbattle.bullet;

public class WestBullet extends Bullet{
	public WestBullet(int x, int y) {
		super(x-20, y);
	}

	public void bulletFly() {
		this.setX(this.getX() - this.getSpeed());
	}
}
