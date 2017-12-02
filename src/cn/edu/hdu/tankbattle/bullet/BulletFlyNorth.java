package cn.edu.hdu.tankbattle.bullet;

public class BulletFlyNorth implements IBulletFly {
	public void bulletFly(Bullet bullet) {
		bullet.setY(bullet.getY() - bullet.getSpeed());
	}
}
