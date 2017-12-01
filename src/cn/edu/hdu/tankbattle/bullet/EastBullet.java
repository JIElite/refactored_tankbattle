package cn.edu.hdu.tankbattle.bullet;

public class EastBullet extends Bullet {
	public EastBullet(int x, int y) {
		super(x+20, y);
	}

	public void bulletFly() {
		this.setX(this.getX() + this.getSpeed());
	}
}
