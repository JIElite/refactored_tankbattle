package cn.edu.hdu.tankbattle.model.bullet;

public class BulletFlyEast implements IBulletFly {
	public void bulletFly(Bullet bullet) {
		bullet.setX(bullet.getX() + bullet.getSpeed());
	}
}
