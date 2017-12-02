package cn.edu.hdu.tankbattle.bullet;

public class BulletFlyEast implements IBulletFly {
	public void bulletFly(Bullet bullet) {
		bullet.setX(bullet.getX() + bullet.getSpeed());
	}
}
